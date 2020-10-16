package com.toy.board.vo;

import java.sql.Date;


public class BoardVo {
	
	/** 게시판번호 */
	private int boardNo;
	/** 게시판제목 */
	private String boardTitle;
	/** 게시판내용 */
	private String boardContent;
	/** 게시판작성자ID */
	private String boardUserId;
	/** 게시판작성일 */
	private Date boardRegdate;	
	/** 게시판검색종류 */
	private String search;	
	/** 게시판검색단어 */
	private String keyword;

	/** 시작페이지 */
	private int pageStart;
	/** 게시글 갯수 */
	private int perPageNum;
	/** 게시글 더보기 */
	private int morePage;

	
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
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardUserId() {
		return boardUserId;
	}
	public void setBoardUserId(String boardUserId) {
		this.boardUserId = boardUserId;
	}
	public Date getBoardRegdate() {
		return boardRegdate;
	}
	public void setBoardRegdate(Date boardRegdate) {
		this.boardRegdate = boardRegdate;
	}
	public int getMorePage() {
		return morePage;
	}
	public void setMorePage(int morePage) {
		this.morePage = morePage;
	}
	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}
	public int getPageStart() {
		return pageStart;
	}
	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}
	
}
