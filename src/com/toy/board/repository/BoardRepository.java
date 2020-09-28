package com.toy.board.repository;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.toy.common.mapper.SqlSessionMapper;

@Repository
public class BoardRepository {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private SqlSessionMapper mapper;


	public List<Map> selectBoardList() {
		List<Map> boardList = mapper.selectList("board.BoardRepository.selectList");
		logger.debug("boardList : {}", boardList);
		return boardList;
	}


	public Map selectBoardDetail(Map param) {
		logger.debug("param: {}", param);
		logger.debug("param.BOARD_NO: {}", param.get("BOARD_NO"));
		
		Map boardDetail = mapper.select("board.BoardRepository.selectDetail", param);
		return boardDetail;
	}
	
	public int insertBoard(Map param) {
		logger.debug("11111111param {}", param);
		logger.debug("param.BOARD_TITLE: {}", param.get("BOARD_TITLE"));
		
		int boardInsert = mapper.insert("board.BoardRepository.insertBoard", param);
		return boardInsert;
	}
}
