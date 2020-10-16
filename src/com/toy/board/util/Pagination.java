package com.toy.board.util;

public class Pagination {

	private Criteria cri;
	/** 전체 갯수 */
	private int totalCount;
	/** 시작페이지 */
	private int startPage;
	/** 끝 페이지 */
	private int endPage;
	/** 이전으로 */
	private boolean prev;
	/** 다음으로 */
	private boolean next;
	/** 보여줄 페이지 넘버수 */
	private int displayPageNum = 5;
	
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		// 호출함수가 왜 여기에 들어와야되는지 이해가 잘안됨.
		calcData();
	}
	
	private void calcData() {
		// math.ceil 소수값이 있을때 올리는 함수
		// (현재 페이지 번호 / 화면에 보여질 페이지번호 갯수) * 화면에 보여질 페이지 번호 갯수
		// 시작번호 구하는 공식인지는 알겠는데 왜 이식으로 계산하는지는 이해가 잘안됨.
		endPage = (int)(Math.ceil(cri.getPage() / (double)displayPageNum) * displayPageNum);
		
		// 끝페이지 번호 - 화면에 보여질 페이지번호 갯수 + 1
		startPage = (endPage - displayPageNum) + 1;
		// 시작페이지가 0보다 작으면 1로 셋팅
		if (startPage <= 0) {
			startPage = 1;
		}
		
		// 진짜 끝페이지 번호
		// 전체 게시물 갯수 / 화면에 보여줄 게시물 갯수
		int tempEndPage = (int)(Math.ceil(totalCount / (double)cri.getPerPageNum()));
		if (endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		// 이전 버튼 생성 여부 = 시작 페이지 번호 == 1 ? false : true
		prev = startPage == 1 ? false : true;
		// 다음 버튼 생성 여부 = 끝 페이지 번호 * 한 페이지당 보여줄 게시글의 갯수 < 총 게시글의 수 ? true: false
		next = endPage * cri.getPerPageNum() < totalCount ? true : false;
	}
	
	
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}
	
}
