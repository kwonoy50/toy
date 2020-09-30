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
	public ModelAndView boardList(@RequestParam Map<String, String> param) {		
		ModelAndView mav = new ModelAndView("board/list");

		mav.addObject("boardList", boardService.getBoardList());
		
		return mav;
	}
	
	@RequestMapping("/board/detail")
	public ModelAndView boardDetail(@RequestParam Map param) {	
		ModelAndView mav = new ModelAndView("board/detail");
		
		Map detail = boardService.getBoardDetail(param);
		
		mav.addObject("boardDetail", detail);
		
		return mav;
	}
	
	@RequestMapping("/board/goWrite")
	public String goWrite() {
		
		return "/board/write";
	}
	
	/*
	 * @RequestMapping("/board/insert") public ModelAndView
	 * boardInsert(@RequestParam Map param) { ModelAndView mav = new ModelAndView();
	 * logger.debug("333333333param {}", param);
	 * logger.debug("param.BOARD_TITLE: {}", param.get("BOARD_TITLE"));
	 * 
	 * mav.addObject("boardInsert", boardService.setInsertBoard(param));
	 * mav.setViewName("board/list");
	 * 
	 * return mav; }
	 */
	
	@RequestMapping("/board/insert")
	public String boardInsert(@RequestParam Map param) {
		boardService.setInsertBoard(param);
		
		//redirect 하지않으면 계속 등록됨.
		return "redirect:/board/list";
	}
	
	@RequestMapping("/board/delete")
	public String boardDelete(@RequestParam Map param) {
		boardService.setDeleteBoard(param);
		
		return "redirect:/board/list";
	}
		
	@RequestMapping("/board/goUpdate")
	public ModelAndView goUpdate(@RequestParam Map param) {	
		ModelAndView mav = new ModelAndView("board/update");
		
		Map update = boardService.getBoardDetail(param);
		
		mav.addObject("boardUpdate", update);
		
		return mav;
	}
	
	@RequestMapping("/board/update")
	public String boardUpdate(@RequestParam Map param) {
		boardService.setUpdateBoard(param);
		
		return "redirect:/board/list";
	}
		
}
