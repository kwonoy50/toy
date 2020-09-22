package com.toy.board.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.toy.common.mapper.SqlSessionMapper;

@Repository
public class BoardRepository {

	@Autowired
	private SqlSessionMapper mapper;
	
	public List<Map> selectBoardList(){
		List<Map> boardList = mapper.selectList("board.BoardRepository.selectBoards");
		return boardList;
	}
	
	public List<Map> selectUserList(){
		List<Map> userList = mapper.selectList("user.UserRepository.selectUsers");
		return userList;
	}
}
