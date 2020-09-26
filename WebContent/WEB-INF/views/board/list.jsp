
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="ko">


<head>
    <meta charset="UTF-8">
    <title>목록</title>
</head>

<body>
<script type="text/javascript">

</script>
<h2>게시글 목록</h2>
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
				<td>${row.BNO}</td>
				<td><a href="<c:url value='/detail?bno=${row.BNO}'/>">${row.TITLE}</a></td>
				<td>${row.WRITER}</td>
				<%-- <td>${row.REGDATE}</td> --%>
				<fmt:parseDate value="${row.REGDATE}" var="dateFmt" pattern="yyyyMMdd"/>				
				<td><fmt:formatDate value="${dateFmt}" pattern="yyyy.MM.dd"/></td>				
			</tr>
		</c:forEach>
	</tbody>
</table>

</body>


</html>
