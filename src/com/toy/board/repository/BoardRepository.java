package com.toy.board.repository;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.toy.board.vo.BoardVo;
import com.toy.common.mapper.SqlSessionMapper;

@Repository
public class BoardRepository {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private SqlSessionMapper mapper;


	/**
	 * 게시물목록을 조회한다.
	 * 
	 * @param param 파라메타 vo
	 * @return 게시물목록
	 */
	public List<BoardVo> selectBoardList(BoardVo param) {
		List<BoardVo> boardList = mapper.selectList("board.BoardRepository.selectList", param);
		logger.debug("boardList : {}", boardList);
		return boardList;
	}


	/**
	 * 게시물상세내용을 조회한다.
	 * 
	 * @param param 파라메타 vo
	 * @return 게시물상세
	 */
	public BoardVo selectBoardDetail(BoardVo param) {
//		BoardVo vo = new BoardVo();;
//		logger.debug("param.BOARD_NO: {}", param.get("BOARD_NO123"));
//		logger.debug("param.BOARD_NO: {}", vo.getBoardNo123());

		BoardVo boardDetail = mapper.select("board.BoardRepository.selectDetail", param);
		return boardDetail;
	}
	
	
	/**
	 * 게시물을 등록한다.
	 * 
	 * @param param 파라메타 vo
	 * @return 게시물등록
	 */
	public int writeBoard(BoardVo param) {
		logger.debug("11111111param {}", param);
		logger.debug("param.BOARD_TITLE: {}", param.getBoardNo());
		
		int boardInsert = mapper.insert("board.BoardRepository.writeBoard", param);
		return boardInsert;
	}
	
	
	/**
	 * 게시물을 삭제한다.
	 * 
	 * @param param 파라메타 vo
	 * @return 게시물삭제
	 */
	public int deleteBoard(BoardVo param) {
		int boardDelete = mapper.delete("board.BoardRepository.deleteBoard", param);
		
		return boardDelete;
	}
	
	
	/**
	 * 게시물상세내용을 수정한다.
	 * 
	 * @param param 파라메타 vo
	 * @return 게시물수정
	 */
	public int updateBoard(BoardVo param) {
		int boardUpdate = mapper.delete("board.BoardRepository.updateBoard", param);
		
		return boardUpdate;
	}

	
}
