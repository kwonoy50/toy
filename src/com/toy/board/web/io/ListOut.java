package com.toy.board.web.io;

import java.util.List;

import com.toy.board.vo.BoardVo;


public class ListOut {

	/** 게시판검색종류 */
	private String search;	
	/** 게시판검색단어 */
	private String keyword;
	/** 게시글 더보기 */
	private int morePage;
	/** 게시물 총 갯수 */
	private int totalCount;
	/** 게시글 보기 갯수 */
	private int listCount;
	
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
	public int getMorePage() {
		return morePage;
	}
	public void setMorePage(int morePage) {
		this.morePage = morePage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getListCount() {
		return listCount;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}	
	
}
