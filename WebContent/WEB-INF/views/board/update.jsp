
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
<script type="text/javascript">


$(document).ready(function() {
	$('#btnUpdate').click(function() {
		if(confirm("수정하시겠습니까?")){
			$('#frm').submit();			
		}
	});
});


</script>
<h2>게시글 수정</h2>
<button type="button" onclick="location.href='list'">목록</button>
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
            <td><input type="text" style="width: 99%" name="BOARD_TITLE" placeholder="제목을 입력해 주세요." value="${boardUpdate.BOARD_TITLE}"/></td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><input type="text" style="width: 99%" name="BOARD_USER_ID" placeholder="작성자를 입력해 주세요."value="${boardUpdate.BOARD_USER_ID}"/></td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea style="width: 99%" rows="10" name="BOARD_CONTENT" placeholder="내용을 입력해 주세요.">${boardUpdate.BOARD_CONTENT}</textarea></td>
        </tr>
    </tbody>
</table>
<input type="hidden" name="BOARD_NO" value="${boardUpdate.BOARD_NO}" />

</form>
</body>


</html>
