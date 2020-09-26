package com.toy.board.web;

import java.util.List;
import java.util.Map;

import javax.activation.CommandMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.toy.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/board/list")
	public ModelAndView list(@RequestParam Map<String, String> param) {		
		ModelAndView mav = new ModelAndView("board/list");

		mav.addObject("boardList", boardService.getBoardList());
		
		return mav;
	}
	
	@RequestMapping("/board/detail")
	public ModelAndView detail(@RequestParam Map param) {	
		ModelAndView mav = new ModelAndView("board/detail");
		
		Map detail = boardService.getBoardDetail(param);
		
		mav.addObject("boardDetail", detail);
		
		return mav;
	}
	
}
