package com.toy.board.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public ModelAndView writeWithGet() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/write");
		
		return mav;
	}
	
	
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public ModelAndView writeWithPost(@RequestParam Map param) {
		ModelAndView mav = new ModelAndView();
		//redirect 경우 /board/list 하였을경우 /board/board/list
		mav.setViewName("redirect:list");
		boardService.setInsertBoard(param);
		
		return mav;		
	}
	
	
	@RequestMapping(value = "/board/update", method = RequestMethod.GET)
	public ModelAndView updateWithGet(@RequestParam Map param) {
		ModelAndView mav = new ModelAndView();
		Map update = boardService.getBoardDetail(param);
		
		mav.addObject("boardUpdate", update);
		mav.setViewName("board/update");
		
		return mav;
	}
	
	
	@RequestMapping(value = "/board/update", method = RequestMethod.POST)
	public ModelAndView updateWithPost(@RequestParam Map param) {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("redirect:list");
		boardService.setUpdateBoard(param);
		
		return mav;
	}	
	
	
	@RequestMapping("/board/delete")
	public String boardDelete(@RequestParam Map param) {
		boardService.setDeleteBoard(param);
		
		return "redirect:/board/list";
	}	

}
