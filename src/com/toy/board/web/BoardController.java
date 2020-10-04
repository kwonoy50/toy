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
import com.toy.board.vo.BoardVo;
import com.toy.board.web.io.DetailIn;
import com.toy.board.web.io.DetailOut;

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


	/**
	 * 게시물상세 조회
	 * 
	 * @param in Input
	 * @return ModelAndView
	 */
	@RequestMapping("/board/detail")
	public ModelAndView boardDetail(DetailIn in) {
		// parameter 설정
		BoardVo paramVo = new BoardVo();
		paramVo.setBoardNo(in.getBoardNo());  // 게시물번호
		
		// 서비스 호출
		BoardVo resultVo = boardService.getBoardDetail(paramVo);
		
		// Out 값 설정
		DetailOut out = new DetailOut();
		out.setBoardNo(resultVo.getBoardNo());            // 게시물번호
		out.setBoardTitle(resultVo.getBoardTitle());      // 게시물제목
		out.setBoardContent(resultVo.getBoardContent());  // 게시물내용
		out.setBoardUserId(resultVo.getBoardUserId());    // 게시물작성자ID
		out.setBoardRegdate(resultVo.getBoardRegdate());  // 게시물등록일자

		// view 설정
		ModelAndView mav = new ModelAndView("board/detail");
		mav.addObject("detailOut", out);

		return mav;
	}

	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public ModelAndView write() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/write");

		return mav;
	}

	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public ModelAndView write(@RequestParam Map param) {
		ModelAndView mav = new ModelAndView();
		// redirect 경우 /board/list 하였을경우 /board/board/list
		mav.setViewName("redirect:/board/list");
		boardService.setInsertBoard(param);

		return mav;
	}

	@RequestMapping(value = "/board/update", method = RequestMethod.GET)
	public ModelAndView updateWithGet(@RequestParam Map param) {
		ModelAndView mav = new ModelAndView();
//		Map update = boardService.getBoardDetail(param);

//		mav.addObject("boardUpdate", update);
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
	public ModelAndView boardDelete(@RequestParam Map param) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:list");
		boardService.setDeleteBoard(param);

		return mav;
	}

	@RequestMapping("/board/search")
	public ModelAndView boardSearch(@RequestParam Map param) {
		ModelAndView mav = new ModelAndView("board/list");
		logger.debug("param {}", param);
		
		mav.addObject("boardList", boardService.getBoardSearch(param));

		return mav;
	}
}
