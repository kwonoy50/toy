<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html lang="ko">
	<head>
	    <meta charset="UTF-8">
	    <title>목록</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<style type="text/css">
			a:hover   { cursor:pointer; text-decoration:underline; color:#FF0000 }
			a.no-uline:hover   { text-decoration:underline }
		</style>
	</head>	
	<body>
		<h2>게시글 목록</h2>
		<div>
			<button type="button" id="btnWrite">글쓰기</button>
		</div>
		<form id="frm" name="frm" action="/board/detail" method="get">
			<input type="hidden" id="boardNo" name="boardNo" value="" />
			<input type="hidden" id="search" name="search" value="${out.search}" />
			<input type="hidden" id="keyword" name="keyword" value="${out.keyword}" />
		</form>
		<form id="frmSearch" name="frmSearch" action="/board/list" method="get">
			<select name="search">
				<option value="title" <c:if test="${out.search == 'title'}">selected="selected"</c:if>>제목</option>
				<option value="userId" <c:if test="${out.search == 'userId'}">selected="selected"</c:if>>작성자</option>
				<option value="content" <c:if test="${out.search == 'content'}">selected="selected"</c:if>>내용</option>
			</select>
			<input type="text" name="keyword" id="keyword" value="${out.keyword}"/>
			<button type="button" id="btnSearch">조회</button>
		</form>
		<table border="1" width="600">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty out.boardList}" >
					<tr><td colspan="4" align="center">데이터가 없습니다.</td></tr>			
				</c:if>
				<c:forEach var="row" items="${out.boardList}" varStatus="status">
					<tr>
						<td>${row.boardNo}</td>
						<td><a onclick="goDetail('${row.boardNo}')">${row.boardTitle}</a></td>
						<td>${row.boardUserId}</td>
						<td><fmt:formatDate value="${row.boardRegdate}" pattern="yyyy.MM.dd"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form id="frmPage" name="frmPage" action="/board/list" method="get">
			<input type="hidden" id="page" name="page" value="">
			<input type="hidden" id="search" name="search" value="${out.search}" />
			<input type="hidden" id="keyword" name="keyword" value="${out.keyword}" />
		</form>
		<table border="1" width="600">
			<tr>
				<td align="center">
			    <c:if test="${pageMaker.prev}">
			    	<a onclick="goPrev('${pageMaker.startPage-1}')">&nbsp;<&nbsp;</a>
			    </c:if>
			    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="pageNum">
			    	&nbsp;<a onclick="goPaging('${pageNum}')">${pageNum}</a>&nbsp;
			    </c:forEach>
			    <c:if test="${pageMaker.next && pageMaker.endPage >0 }">
			    	<a onclick="goNext('${pageMaker.endPage+1}')">&nbsp;>&nbsp;</a>
			    </c:if>
			    </td>
			</tr>
		</table>
		<script type="text/javascript">
		
		$(document).ready(function() {
			var $frm = $('#frm');
			var $frmSearch = $('#frmSearch');
			
			// 글쓰기 페이지 이동
			$('#btnWrite').click(function() {
				$frm.attr('action', '/board/write');
				$frm.submit();
			});
			
			// 검색
			$('#btnSearch').click(function() {
				$frmSearch.attr('action', '/board/list');
				$frmSearch.submit();
			});
			
			// Enter키 조회 클릭
			$('#keyword').keydown(function(evt) {
				if (evt.keyCode == 13) {
					$('#btnSearch').click();
				}
			});
		});	
		
		// 상세페이지 이동
		function goDetail(boardNo) {
			$('#boardNo').val(boardNo);
			$('#frm').submit();
		}
		
		// 페이징 이동
		function goPaging(page) {
			$('#page').val(page);
			$('#frmPage').submit();
		}
		
		// 이전으로 이동
		function goPrev(page) {
			$('#page').val(page);
			$('#frmPage').submit();
		}
		
		// 다음으로 이동
		function goNext(page) {
			$('#page').val(page);
			$('#frmPage').submit();
		}
		
		</script>
	</body>
</html>
