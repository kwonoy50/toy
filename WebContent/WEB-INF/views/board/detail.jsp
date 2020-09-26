
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">


<head>
    <meta charset="UTF-8">
    <title>상세보기</title>
</head>

<body>
<script type="text/javascript">

</script>
<h2>게시글 상세보기</h2>
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
            <td colspan="3">${boardDetail.TITLE}</td>
        </tr>
        <tr>
            <th>작성자</th>
            <td>${boardDetail.WRITER}</td>
            <th>작성일</th>
            <fmt:parseDate value="${boardDetail.REGDATE}" var="dateFmt" pattern="yyyyMMdd"/>				
			<td><fmt:formatDate value="${dateFmt}" pattern="yyyy.MM.dd"/></td>			
        </tr>
        <tr>
            <th>내용</th>
            <td colspan="3">${boardDetail.CONTENTS}</td>
        </tr>
    </tbody>
</table>
<pre>${boardDetail}</pre>



</body>


</html>
