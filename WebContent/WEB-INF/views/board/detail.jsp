
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
<script type="text/javascript">

function deleteBoard() {
	if(confirm("삭제하시겠습니까?")){
		//$('#frm').action = "/board/delete";
		$("#frm").attr("action", "/board/delete");
		$('#frm').submit();
	}
}

$(function(){
	$('#btn_delete').click(function() {
		if(confirm("삭제하시겠습니까?")){
			$("#frm").attr("action", "/board/delete");
			$('#frm').submit();
		}
	});
});

$(function() {
	$('#btn_update').click(function(){
		location.href = "goUpdate?BOARD_NO=${boardDetail.BOARD_NO}";	
	});
});


</script>
<h2>게시글 상세</h2>
<button type="button" onclick="location.href='list'">목록</button>
<button type="button" id="btn_delete">삭제</button>
<button type="button" onclick="deleteBoard()">삭제2</button>

<button type="button" id="btn_update">수정</button>
<form id="frm" method="post">
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
	            <td colspan="3">${boardDetail.BOARD_TITLE}</td>
	        </tr>
	        <tr>
	            <th>작성자</th>
	            <td>${boardDetail.BOARD_USER_ID}</td>
	            <th>작성일</th>	
				<td><fmt:formatDate value="${boardDetail.BOARD_REGDATE}" pattern="yyyy.MM.dd"/></td>			
	        </tr>
	        <tr>
	            <th>내용</th>
	            <td colspan="3">${boardDetail.BOARD_CONTENT}</td>
	        </tr>
	    </tbody>
	</table>
	<input type="hidden" name="BOARD_NO" value="${boardDetail.BOARD_NO}" />
</form>

</body>


</html>
