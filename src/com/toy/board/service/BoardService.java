package com.toy.board.service;

import java.util.List;
import java.util.Map;

import javax.activation.CommandMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toy.board.repository.BoardRepository;

@Service
public class BoardService {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private BoardRepository boardRepository;
	
	public List<Map> getBoardList(){
		return boardRepository.selectBoardList();
	}


	public Map getBoardDetail(Map param) {
		
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
