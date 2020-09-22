package com.toy.board.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.toy.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/list")
	public ModelAndView list(@RequestParam Map<String, String> pram) {		
		ModelAndView mav = new ModelAndView("board/list");
				
		mav.addObject("boardList", boardService.getBoardList());
		mav.addObject("userList", boardService.getUserList());
		
		return mav;
	}
}
