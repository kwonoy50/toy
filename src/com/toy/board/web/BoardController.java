package com.toy.board.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
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
	
	@RequestMapping("/board/write")
	public String write() {
		
		return "/board/write";
	}
	
	@RequestMapping("/board/insert")
	public ModelAndView insert(@RequestParam Map param) {
		ModelAndView mav = new ModelAndView();
		logger.debug("333333333param {}", param);
		logger.debug("param.BOARD_TITLE: {}", param.get("BOARD_TITLE"));
		
		mav.addObject("boardInsert", boardService.setInsertBoard(param));	
		mav.setViewName("board/list");
		
		return mav;
	}
}
