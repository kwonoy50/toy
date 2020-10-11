package com.toy.board.web.io;

import java.util.List;

import com.toy.board.vo.BoardVo;


public class ListOut {

	/** 게시판검색종류 */
	private String search;	
	/** 게시판검색단어 */
	private String keyword;
    /** 게시물 목록 */
	private List<BoardVo> boardList;
	
	
	public List<BoardVo> getBoardList() {
		return boardList;
	}
	public void setBoardList(List<BoardVo> boardList) {
		this.boardList = boardList;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
