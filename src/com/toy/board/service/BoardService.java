package com.toy.board.service;

import java.util.List;
import java.util.Map;

import javax.activation.CommandMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toy.board.repository.BoardRepository;
import com.toy.board.util.Pagination;
import com.toy.board.vo.BoardVo;

@Service
public class BoardService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private BoardRepository boardRepository;
	
	/**
	 * 게시물목록을 조회한다.
	 * 
	 * @param param 파라메타 vo
	 * @return 게시물목록
	 */
	public List<BoardVo> getBoardList(BoardVo param){
		
		List<BoardVo> aa = boardRepository.selectBoardList(param);
	
		return aa;
	}

	
	/**
	 * 게시물갯수를 조회한다.
	 * 
	 * @param param 
	 * @return 게시물갯수
	 */
	public int getBoardCount(BoardVo param) {
		return boardRepository.countBoard(param);
	}

	
	/**
	 * 게시물상세내용을 조회한다.
	 * 
	 * @param param 파라메타 vo
	 * @return 게시물상세
	 */
	public BoardVo getBoardDetail(BoardVo param) {
		
		logger.debug("param {}", param);
		return boardRepository.selectBoardDetail(param);
	}
	
	
	/**
	 * 게시물을 등록한다.
	 * 
	 * @param param 파라메타 vo
	 * @return 게시물등록
	 */
	public int setWriteBoard(BoardVo param) {
		logger.debug("2222222param {}", param);
		return boardRepository.writeBoard(param);
	}
	
	
	/**
	 * 게시물을 삭제한다.
	 * 
	 * @param param 파라메타 vo
	 * @return 게시물삭제
	 */
	public int setDeleteBoard(BoardVo param) {
		return boardRepository.deleteBoard(param);
	}	
	
	
	/**
	 * 게시물상세내용을 수정한다.
	 * 
	 * @param param 파라메타 vo
	 * @return 게시물수정
	 */
	public int setUpdateBoard(BoardVo param) {
		return boardRepository.updateBoard(param);
	}
	
}
