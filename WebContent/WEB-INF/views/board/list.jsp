
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
<form>
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
					<td>${row.BOARD_NO}</td>
					<td><a href="<c:url value='/board/detail?BOARD_NO=${row.BOARD_NO}'/>">${row.BOARD_TITLE}</a></td>
					<td>${row.BOARD_USER_ID}</td>
					<td><fmt:formatDate value="${row.BOARD_REGDATE}" pattern="yyyy.MM.dd"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</form>
</body>
</html>
