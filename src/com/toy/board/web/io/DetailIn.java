package com.toy.board.web.io;



public class DetailIn {
	
	/** 게시판번호 */
	private int boardNo;
	/** 게시판검색종류 */
	private String search;	
	/** 게시판검색단어 */
	private String keyword;

	
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

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	
	

}
