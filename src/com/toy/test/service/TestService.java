package com.toy.test.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.toy.test.repository.TestRepository;



@Service
public class TestService {
	
	@Autowired
	private TestRepository testRpository;

	
	public List<Map> getMessageList() {
		return testRpository.selectMessageList();
	}

}
