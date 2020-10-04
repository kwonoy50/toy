
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
		
		$(document).ready(function() {
			var $frm = $('#frm');
			$('#btnDelete').click(function() { //요즘방법
				if(confirm("삭제하시겠습니까?")){
					$frm.attr("action", "/board/delete");
					$frm.submit();
				}
			});
		
			$('#btnUpdate').click(function() {
				$frm.attr('action', '/board/update');
				$frm.submit();
			});
		});
		
		</script>
		<h2>게시글 상세</h2>
		<button type="button" onclick="history.back()">목록</button>
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
			            <td colspan="3"><pre>${boardDetail.BOARD_CONTENT}</pre></td>
			        </tr>
			    </tbody>
			</table>
			<input type="hidden" name="BOARD_NO" value="${boardDetail.BOARD_NO}" />
		</form>
	</body>
</html>
