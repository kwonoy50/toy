
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">


<head>
    <meta charset="UTF-8">
    <title>목록</title>
<style type="text/css">
a:hover   { cursor:pointer; text-decoration:underline; color:#FF0000 }
a.no-uline:hover   { text-decoration:underline }
</style>
</head>

<body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#button2').click(function(){
		$(location).attr('href','write');
	});
});

$(function() {
	$('#button3').click(function(){
		location.href = "goWrite";	
	});
});

$(function() {
	$('#BOARD_TITLE').click(function(){
		alert("11111");
		//location.href = "/board/detail?BOARD_NO=${row.BOARD_NO}"		
	});
});

function goDetail() {
	$("#frm").attr("action", "/board/detail");
	$('#frm').submit();
}

</script>
<h2>게시글 목록</h2>
<div>
<button type="button" onclick="location.href='goWrite'">글쓰기</button>
<button type="button" id="button2">글쓰기2</button>
<button type="button" id="button3">글쓰기3</button>
</div>
<form id="frm" method="post">
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
				<tr><td colspan="5" align="center">데이터가 없습니다.</td></tr>			
			</c:if>
			<c:forEach var="row" items="${boardList}" varStatus="status">
				<tr>
					<td><input type="hidden" name="BOARD_NO" value="${row.BOARD_NO}">${row.BOARD_NO}</td>					
					<td><a onclick="goDetail()">${row.BOARD_TITLE}</a></td>
					<%-- <td><a href="#" id="BOARD_TITLE")">${row.BOARD_TITLE}</a></td> --%>
					<%-- <td><a href="<c:url value='/board/detail?BOARD_NO=${row.BOARD_NO}'/>">${row.BOARD_TITLE}</a></td> --%>
					<td>${row.BOARD_USER_ID}</td>
					<td><fmt:formatDate value="${row.BOARD_REGDATE}" pattern="yyyy.MM.dd"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</form>
</body>
</html>
