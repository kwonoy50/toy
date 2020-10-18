package com.toy.board.util;

public class Criteria {
	
	/** 현재페이지 */
	private int page;
	/** 게시글 갯수 */
	private int perPageNum;

	public Criteria() {
		// 기본값 설정
		this.page = 1;
		this.perPageNum = 5;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		// 음수가 들어가지 않게 설정
		if (page <= 0) {
			this.page = 1;
		} else {
			this.page = page;
		}
	}
	
	public int getPageStart() {
		return (this.page-1)*perPageNum;
	}
	
	public int getPerPageNum() {
		return perPageNum;
	}

	// pageCount 설정하는 부분이 이해가 안됨.
	public void setPerPageNum(int pageCount) {
		if (pageCount != this.perPageNum) {
			this.perPageNum = pageCount;
		}
	}
	

}
