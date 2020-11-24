package com.toy.board.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.toy.board.service.BoardService;
import com.toy.board.util.Criteria;
import com.toy.board.util.Pagination;
import com.toy.board.vo.BoardVo;
import com.toy.board.web.io.DeleteIn;
import com.toy.board.web.io.DetailIn;
import com.toy.board.web.io.DetailOut;
import com.toy.board.web.io.ListIn;
import com.toy.board.web.io.ListOut;
import com.toy.board.web.io.UpdateIn;
import com.toy.board.web.io.WriteIn;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 게시물목록 조회
	 * 
	 * @param in Input
	 * @return ModelAndView
	 */
	@RequestMapping("/board/list")
	public ModelAndView list(ListIn in) {
		// parameter 설정
		Criteria cri = new Criteria();
		cri.setPage(in.getPage());
		if (in.getListCount() != 0) {
			cri.setPerPageNum(in.getListCount());
		}

		logger.debug("getListCount : {}", in.getListCount());
		logger.debug("setPerPageNum : {}", cri.getPerPageNum());
		
		BoardVo paramVo = new BoardVo();
		paramVo.setSearch(in.getSearch());
		paramVo.setKeyword(in.getKeyword());
		paramVo.setPageStart(cri.getPageStart());
		paramVo.setPerPageNum(cri.getPerPageNum());
		paramVo.setMorePage(in.getMorePage());

//		if (in.getMorePage() == 0) {
//			paramVo.setMorePage(5);
//		} else {
//			paramVo.setMorePage(in.getMorePage() + 5);
//		}

		logger.debug("getPage : {}", cri.getPage());
		logger.debug("getPageStart : {}", cri.getPageStart());
		logger.debug("getPerPageNum : {}", cri.getPerPageNum());
		
		Pagination pagination = new Pagination();
		pagination.setCri(cri);
		pagination.setTotalCount(boardService.getBoardCount(paramVo));
		logger.debug("getBoardCount : {}", pagination.getTotalCount());
		logger.debug("getMorePage : {}", paramVo.getMorePage());

		// 서비스 호출
		List<BoardVo> boardList = boardService.getBoardList(paramVo);
		
		int morePage = in.getMorePage() + cri.getPerPageNum();
		
		ListOut out = new ListOut();
		out.setBoardList(boardList);
		out.setSearch(in.getSearch());
		out.setKeyword(in.getKeyword());
		out.setMorePage(morePage);
		out.setTotalCount(pagination.getTotalCount());
		out.setListCount(cri.getPerPageNum());

		// view 설정 및 오브젝트 삽입
		ModelAndView mav = new ModelAndView("board/list");
		mav.addObject("out", out);
		mav.addObject("pagination", pagination);
		
		return mav;
	}
	

	/**
	 * 게시물상세 조회
	 * 
	 * @param in Input
	 * @return ModelAndView
	 */
	@RequestMapping("/board/detail")
	public ModelAndView detail(DetailIn in) {
		// parameter 설정
		BoardVo paramVo = new BoardVo();
		paramVo.setBoardNo(in.getBoardNo()); // 게시물번호

		// 서비스 호출
		BoardVo resultVo = boardService.getBoardDetail(paramVo);

		// Out 값 설정
		DetailOut out = new DetailOut();
		out.setBoardNo(resultVo.getBoardNo());           // 게시물번호
		out.setBoardTitle(resultVo.getBoardTitle());     // 게시물제목
		out.setBoardContent(resultVo.getBoardContent()); // 게시물내용
		out.setBoardUserId(resultVo.getBoardUserId());   // 게시물작성자ID
		out.setBoardRegdate(resultVo.getBoardRegdate()); // 게시물등록일자
		
		// 검색 조건 유지
		out.setSearch(in.getSearch());
		out.setKeyword(in.getKeyword());
		
		logger.debug("getKeyword : {}", in.getKeyword());

		// view 설정 및 오브젝트 삽입
		ModelAndView mav = new ModelAndView("board/detail");
		mav.addObject("detailOut", out);

		return mav;
	}

	
	/**
	 * 게시물등록 페이지 이동
	 * 
	 * @param in Input
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public ModelAndView write() {
		// view 설정
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/write");

		return mav;
	}

	
	/**
	 * 게시물등록
	 * 
	 * @param in Input
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public ModelAndView write(WriteIn in) {
		// parameter 설정
		BoardVo paramVo = new BoardVo();
		paramVo.setBoardTitle(in.getBoardTitle());     // 게시물제목
		paramVo.setBoardContent(in.getBoardContent()); // 게시물내용
		paramVo.setBoardUserId(in.getBoardUserId());   // 게시물작성자

		// 서비스 호출
		boardService.setWriteBoard(paramVo);

		// view 설정
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/board/list");

		return mav;
	}

	
	/**
	 * 게시물상세 수정 페이지 이동
	 * 
	 * @param in Input
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/board/update", method = RequestMethod.GET)
	public ModelAndView update(DetailIn in) {
		// parameter 설정
		BoardVo paramVo = new BoardVo();
		paramVo.setBoardNo(in.getBoardNo()); // 게시물번호

		// 서비스 호출
		BoardVo resultVo = boardService.getBoardDetail(paramVo);
		
		// 검색 조건 유지
		resultVo.setSearch(in.getSearch());
		resultVo.setKeyword(in.getKeyword());

		// view 설정 및 오브젝트 삽입
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardUpdate", resultVo);
		mav.setViewName("board/update");

		return mav;
	}

	
	/**
	 * 게시물상세 수정
	 * 
	 * @param in Input
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/board/update", method = RequestMethod.POST)
	public ModelAndView update(UpdateIn in) {
		// parameter 설정
		BoardVo paramVo = new BoardVo();
		paramVo.setBoardNo(in.getBoardNo());           // 게시물번호
		paramVo.setBoardTitle(in.getBoardTitle());     // 게시물제목
		paramVo.setBoardContent(in.getBoardContent()); // 게시물내용
		paramVo.setBoardUserId(in.getBoardUserId());   // 게시물작성자

		// 서비스 호출
		boardService.setUpdateBoard(paramVo);

		// view 설정
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardNo", in.getBoardNo());
		mav.setViewName("redirect:/board/detail");

		return mav;
	}

	
	/**
	 * 게시물삭제
	 * 
	 * @param in Input
	 * @return ModelAndView
	 */
	@RequestMapping("/board/delete")
	public ModelAndView delete(DeleteIn in) {
		// parameter 설정
		BoardVo paramVo = new BoardVo();
		paramVo.setBoardNo(in.getBoardNo()); // 게시물번호

		// 서비스 호출
		boardService.setDeleteBoard(paramVo);

		// view 설정
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/board/list");

		return mav;
	}

}
