
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
	<script type="text/javascript">
	$(document).ready(function() {
		$('#btnWrite').click(function() {
			//$(location).attr('href', 'write');
			var $frm = $('#frm');
			$frm.attr('action', '/board/write');
			$frm.submit();
		});
	});

	function goDetail(boardNo) {
		$('#BOARD_NO').val(boardNo);
		$('#frm').submit();
	}
	// 검색 기능 추가 작성자, 제목, 내용 콤보박스(검색조건), 검색 후 상세에서 목록이동시 검색조건 유지
	</script>
	<h2>게시글 목록</h2>
	<div>
	<button type="button" id="btnWrite">글쓰기</button>
	</div>
	<form id="frm" name="frm" action="/board/detail" method="get">
		<input type="hidden" id="BOARD_NO" name="BOARD_NO" value="" />
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
			<c:if test="${empty boardList}" >
				<tr><td colspan="4" align="center">데이터가 없습니다.</td></tr>			
			</c:if>
			<c:forEach var="row" items="${boardList}" varStatus="status">
				<tr>
					<td>${row.BOARD_NO}</td>
					<td><a onclick="goDetail('${row.BOARD_NO}')">${row.BOARD_TITLE}</a></td>
					<td>${row.BOARD_USER_ID}</td>
					<td><fmt:formatDate value="${row.BOARD_REGDATE}" pattern="yyyy.MM.dd"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
