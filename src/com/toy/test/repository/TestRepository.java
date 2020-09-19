package com.toy.test.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.toy.common.mapper.SqlSessionMapper;



@Repository
public class TestRepository {
	
	@Autowired
	private SqlSessionMapper mapper;
	
	public List<Map> selectMessageList() {
		
		List<Map> aa = mapper.selectList("common.PropertyRepository.selectProperties");
		return aa;
	}

}
