package com.toy.board.service;

import java.util.List;
import java.util.Map;

import javax.activation.CommandMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toy.board.repository.BoardRepository;
import com.toy.board.vo.BoardVo;

@Service
public class BoardService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private BoardRepository boardRepository;
	
	public List<Map> getBoardList(){
		return boardRepository.selectBoardList();
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
	
	
	public int setInsertBoard(Map param) {
		logger.debug("2222222param {}", param);
		return boardRepository.insertBoard(param);
	}
	
	
	public int setDeleteBoard(Map param) {
		return boardRepository.deleteBoard(param);
	}	
	
	
	public int setUpdateBoard(Map param) {
		return boardRepository.updateBoard(param);
	}
	
	
	public List<Map> getBoardSearch(Map param){
		return boardRepository.selectBoardSearch(param);
	}

}
