
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">	
	<head>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	    <meta charset="UTF-8">
	    <title>수정</title>
	</head>	
	<body>
		<h2>게시글 수정</h2>
		<button type="button" id="btnList">목록</button>
		<button type="button" id="btnUpdate">수정</button>		
		<form id="frm" name="frm" action="/board/update" method="post">
			<table border="1" width="600">
			    <colgroup>
			        <col width="25%">
			        <col width="*">
			    </colgroup>
			    <tbody>
			        <tr>
			            <th>제목</th>
			            <td><input type="text" style="width: 99%" id="boardTitle" name="boardTitle" placeholder="제목을 입력해 주세요." value="${boardUpdate.boardTitle}"/></td>
			        </tr>
			        <tr>
			            <th>작성자</th>
			            <td><input type="text" style="width: 99%" id="boardUserId" name="boardUserId" placeholder="작성자를 입력해 주세요."value="${boardUpdate.boardUserId}"/></td>
			        </tr>
			        <tr>
			            <th>내용</th>
			            <td><textarea style="width: 99%" rows="10" id="boardContent" name="boardContent" placeholder="내용을 입력해 주세요.">${boardUpdate.boardContent}</textarea></td>
			        </tr>
			    </tbody>
			</table>
			<input type="hidden" name="boardNo" value="${boardUpdate.boardNo}" />
			<input type="hidden" id="search" name="search" value="${boardUpdate.search}" />
			<input type="hidden" id="keyword" name="keyword" value="${boardUpdate.keyword}" />
		</form>
		<script type="text/javascript">	
		
		$(document).ready(function() {
			var $frm = $('#frm');
			var $boardTitle = $('#boardTitle');
			var $boardUserId = $('#boardUserId');
			var $boardContent = $('#boardContent');

			// 목록
			$('#btnList').click(function() {
				$frm.attr('action', '/board/list');
				$frm.submit();
			});
			
			// validation
			$('#btnUpdate').click(function() {
				if ($boardTitle.val() == null || $boardTitle.val().trim() == "") {
					alert("제목을 입력해주세요.");
					$boardTitle.focus();
					return;
				}
		
				if ($boardUserId.val() == null || $boardUserId.val().trim() == "") {
					alert("작성자를 입력해주세요.");
					$boardUserId.focus();
					return;
				}
		
				if ($boardContent.val() == null || $boardContent.val().trim() == "") {
					alert("내용을 입력해주세요.");
					$boardContent.focus();
					return;
				}
				
				if(confirm("수정하시겠습니까?")){
					$frm.submit();
				}
			});
		});	
		
		</script>
	</body>
</html>
