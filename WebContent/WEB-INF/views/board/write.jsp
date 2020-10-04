
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
		<script type="text/javascript">
		
		$(document).ready(function() {
			var $frm = $('#frm');
			$('#btnWrite').click(function() {
				if($('#BOARD_TITLE').val() == null || $('#BOARD_TITLE').val().trim() == ""){
					alert("제목을 입력해주세요.");
					$('#BOARD_TITLE').focus();
					return;
				}
		
				if($('#BOARD_USER_ID').val() == null || $('#BOARD_USER_ID').val().trim() == ""){
					alert("작성자를 입력해주세요.");
					$('#BOARD_USER_ID').focus();
					return;
				}
		
				if($('#BOARD_CONTENT').val() == null || $('#BOARD_CONTENT').val().trim() == ""){
					alert("내용을 입력해주세요.");
					$('#BOARD_CONTENT').focus();
					return;
				}
				
				if(confirm("등록하시겠습니까?")){
					$frm.submit();
				}
			});
		});	
		
		</script>
		<h2>게시글 작성</h2>
		<div>
			<button type="button" onclick="location.href='list'">목록</button><!-- 수정, validation 무조건, get -->
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
			            <td><input type="text" style="width: 99%" id="BOARD_TITLE" name="BOARD_TITLE" placeholder="제목을 입력해 주세요."/></td>
			        </tr>
			        <tr>
			            <th>작성자</th>
			            <td><input type="text" style="width: 99%" id="BOARD_USER_ID" name="BOARD_USER_ID" placeholder="작성자를 입력해 주세요."/></td>
			        </tr>
			        <tr>
			            <th>내용</th>
			            <td><textarea style="width: 99%" rows="10" id="BOARD_CONTENT" name="BOARD_CONTENT" placeholder="내용을 입력해 주세요."></textarea></td>
			        </tr>
			    </tbody>
			</table>
		</form>
	</body>
</html>
