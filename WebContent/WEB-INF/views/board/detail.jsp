
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">	
	<head>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	    <meta charset="UTF-8">
	    <title>상세보기</title>
	</head>	
	<body>
		<h2>게시글 상세</h2>
		<button type="button" id="btnList">목록</button>
		<button type="button" id="btnDelete">삭제</button>
		<button type="button" id="btnUpdate">수정</button>
		<form id="frm" name="frm" action="/board/update" method="get">
			<table border="1" width="600">
			    <colgroup>
			        <col width="15%">
			        <col width="35%">
			        <col width="15%">
			        <col width="*">
			    </colgroup>     
			    <tbody>
			        <tr>
			            <th>제목</th>
			            <td colspan="3">${detailOut.boardTitle}</td>
			        </tr>
			        <tr>
			            <th>작성자</th>
			            <td>${detailOut.boardUserId}</td>
			            <th>작성일</th>	
						<td><fmt:formatDate value="${detailOut.boardRegdate}" pattern="yyyy.MM.dd"/></td>			
			        </tr>
			        <tr>
			            <th>내용</th>
			            <td colspan="3"><pre>${detailOut.boardContent}</pre></td>
			        </tr>
			    </tbody>
			</table>
			<input type="hidden" name="boardNo" value="${detailOut.boardNo}" />
			<input type="hidden" id="search" name="search" value="${detailOut.search}" />
			<input type="hidden" id="keyword" name="keyword" value="${detailOut.keyword}" />
		</form>
		<script type="text/javascript">
		
		$(document).ready(function() {
			var $frm = $('#frm');
			
			// 목록
			$('#btnList').click(function() {
				$frm.attr('action', '/board/list');
				$frm.submit();
			});
			
			// 삭제
			$('#btnDelete').click(function() {
				if(confirm('삭제하시겠습니까?')){
					$frm.attr('action', '/board/delete');
					$frm.submit();
				}
			});
		
			// 수정 페이지 이동
			$('#btnUpdate').click(function() {
				$frm.attr('action', '/board/update');
				$frm.submit();
			});
		});
		
		</script>
	</body>
</html>
