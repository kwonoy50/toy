package com.toy.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toy.board.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	public List<Map> getBoardList(){
		return boardRepository.selectBoardList();
	}
	
	public List<Map> getUserList(){
		return boardRepository.selectUserList();
	}
}
