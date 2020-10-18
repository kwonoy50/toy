package com.toy.board.web.io;



public class ListIn {
	
	/** 게시판검색종류 */
	private String search;	
	/** 게시판검색단어 */
	private String keyword;
	/** 현재페이지 */
	private int page;
	/** 게시글 갯수 */
	private int perPageNum;
	/** 게시글 더보기 */
	private int morePage;
	/** 게시글 보기 갯수 */
	private int listCount;
	
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

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
}
