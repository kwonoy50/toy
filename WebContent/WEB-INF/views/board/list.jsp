
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ko">


<head>
    <meta charset="UTF-8">
    <title>목록</title>
</head>

<body>

<h2>게시판 목록</h2>

<table border="1" width="600">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성자</th>
		</tr>
	</thead>
	<tbody>
		<%-- <c:if test="${empty boardList }" >
			<tr><td colspan="5" align="center">데이터가 없습니다.</td></tr>
		</c:if> --%>
		<c:forEach var="row" items="${boardList}">
			<tr>
				<td><c:out value="${row.BNO}"/></td>
				<td>${row.title}</td>
				<td>${row.content}</td>
				<td>${row.writer}</td>
				<%-- <td><c:out value="${boardList}"/></td>
				<td><c:out value="${userList}"/></td>
				<td><c:out value="${userList.USER_NAME}"/>2</td>
				<td><c:out value="${userList.USER_PASSWD}"/>3</td> --%>				
			</tr>
		</c:forEach>
	</tbody>
</table>

<pre>${boardList}</pre>
<pre>${userList}</pre>



</body>


</html>
