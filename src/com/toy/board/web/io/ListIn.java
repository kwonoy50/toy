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

	public ListIn() {
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

	public void setPerPageNum(int pageCount) {
		int cnt = this.perPageNum;
		if (pageCount != cnt) {
			this.perPageNum = cnt;
		} else {
			this.perPageNum = pageCount;
		}
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
