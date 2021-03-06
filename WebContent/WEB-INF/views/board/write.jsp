
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	    <meta charset="UTF-8">
	    <title>글쓰기</title>
	</head>	
	<body>	
		<h2>게시글 작성</h2>
		<div>
			<button type="button" id="btnList">목록</button>
			<button type="button" id="btnWrite">등록</button>		
		</div>
		<form id="frm" name="frm" action="/board/write" method="post">
			<table border="1" width="600">
			    <colgroup>
			        <col width="25%">
			        <col width="*">
			    </colgroup>     
			    <tbody>
			        <tr>
			            <th>제목</th>
			            <td><input type="text" style="width: 99%" id="boardTitle" name="boardTitle" placeholder="제목을 입력해 주세요."/></td>
			        </tr>
			        <tr>
			            <th>작성자</th>
			            <td><input type="text" style="width: 99%" id="boardUserId" name="boardUserId" placeholder="작성자를 입력해 주세요."/></td>
			        </tr>
			        <tr>
			            <th>내용</th>
			            <td><textarea style="width: 99%" rows="10" id="boardContent" name="boardContent" placeholder="내용을 입력해 주세요."></textarea></td>
			        </tr>
			    </tbody>
			</table>
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
			$('#btnWrite').click(function() {
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
				
				if (confirm("등록하시겠습니까?")) {
					$frm.submit();
				}
			});
		});	
		
		</script>
	</body>
</html>
