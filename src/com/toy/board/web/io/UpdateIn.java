package com.toy.board.web.io;

import java.sql.Date;

public class UpdateIn {
	
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
}
