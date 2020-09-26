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
	
	@RequestMapping("/list")
	public ModelAndView list(@RequestParam Map<String, String> param) {		
		ModelAndView mav = new ModelAndView("board/list");

		mav.addObject("boardList", boardService.getBoardList());
		mav.addObject("userList", boardService.getUserList());
		
		return mav;
	}
	
	@RequestMapping("/detail")
	public String detail(@RequestParam String bno, ModelMap model) {
		
		System.out.println("@RequestParam : " + bno);
		
		List<Map> detail = boardService.getBoardDetail(bno);
		System.out.println("detail : " + detail);
		
		model.addAttribute("boardDetail", detail);
		
		return "board/detail";
	}
	
}
