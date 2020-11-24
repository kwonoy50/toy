<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>목록</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<style type="text/css">
			a:hover   { cursor:pointer; text-decoration:underline; color:#FF0000 }
			a.no-uline:hover   { text-decoration:underline }
		</style>
	</head>	
	<body>
		<h2>게시글 목록</h2>
		<div>
			<button type="button" id="btnWrite">글쓰기</button>
		</div>
		<form id="frm" name="frm" action="/board/detail" method="get">
			<input type="hidden" id="boardNo" name="boardNo" value="" />
			<input type="hidden" id="search" name="search" value="${out.search}" />
			<input type="hidden" id="keyword1" name="keyword" value="${out.keyword}" />
			<input type="hidden" id="listCount" name="listCount" value="${out.listCount}" />
		</form>
		<form id="frmSearch" name="frmSearch" action="/board/list" method="get">
			<select name="search">
				<option value="title">제목</option>
				<option value="userId">작성자</option>
				<option value="content">내용</option>
			</select>
			<input type="text" name="keyword" id="keyword" value="${out.keyword}"/>
			<button type="button" id="btnSearch">조회</button>
			<select name="listCount">
				<option value="5">5개</option>
				<option value="10">10개</option>
				<option value="20">20개</option>
			</select>
			<input type="hidden" id="page" name="page" value="0">
			<input type="hidden" id="morePage" name="morePage" value="${out.morePage}">
		</form>
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
				<c:if test="${empty out.boardList}" >
					<tr><td colspan="4" align="center">데이터가 없습니다.</td></tr>			
				</c:if>
				<c:forEach var="row" items="${out.boardList}" varStatus="status">
					<tr>
						<td>${row.boardNo}</td>
						<td><a onclick="goDetail('${row.boardNo}')">${row.boardTitle}</a></td>
						<td>${row.boardUserId}</td>
						<td><fmt:formatDate value="${row.boardRegdate}" pattern="yyyy.MM.dd"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<table border="1" width="600">
			<tr>
				<td align="center">
				<c:if test="${pagination.prev}">
					<!-- 시작 페이지 - 1 이유는 이전 버튼 눌렀을때 지금 시작페이지의 이전 페이징번호의 마지막으로 이동 -->
					<a href="javascript:goPaging('${pagination.startPage - 1}');">&nbsp;&lt;&nbsp;</a>
				</c:if>
				<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="pageNum">
					&nbsp;<a href="javascript:goPaging('${pageNum}');">${pageNum}</a>&nbsp;
				</c:forEach>
				<!-- 이부분 이해가 잘안됨. -->
				<c:if test="${pagination.next && pagination.endPage > 0 }">
					<!-- 마지막 페이지 - 1 이유는 다음 버튼 눌렀을때 지금 마지막페이지의 다음 시작 페이징번호로 이동 -->
					<a href="javascript:goPaging('${pagination.endPage + 1}');">&nbsp;&gt;&nbsp;</a>
				</c:if>
				</td>
			</tr>
		</table>
		<input type="hidden" id="totalCount" name="totalCount" value="${out.totalCount}">
		<table border="1" width="600">
			<tr>
				<td align="center">
					<a href="javascript:goMore('${out.morePage}');" id="more" >더보기</a>
				</td>
			</tr>
		</table>
		<script type="text/javascript">
		
		$(document).ready(function() {
			var $frm = $('#frm');
			var $frmSearch = $('#frmSearch');
			
			// 더보기시 스크롤 맨밑으로 이동
			if ($('#morePage').val() != null) {
				$('html, body').scrollTop(document.body.scrollHeight);
			}
			
			// 글쓰기 페이지 이동
			$('#btnWrite').click(function() {
				$frm.attr('action', '/board/write');
				$frm.submit();
			});
			
			// 검색
			$('#btnSearch').click(function() {
				$('#morePage').val(0);
				//document.getElementById('morePage').value = 0;
				//document.frmSearch.morePage.value = 0;
				$frmSearch.attr('action', '/board/list');
				$frmSearch.submit();
			});
			
			// Enter키 조회 클릭
			$('#keyword').keydown(function(evt) {
				if (evt.keyCode == 13) {
					$('#btnSearch').click();
				}
			});
			
			var searchSelectedValue = "title";
			<c:if test="${not empty out.search}">
				searchSelectedValue = "${out.search}";
			</c:if>
			$('#frmSearch').find('select[name=search]').val(searchSelectedValue);
			
			var listCountValue = 5;
			<c:if test="${out.listCount != 0}">
				listCountValue = ${out.listCount};
			</c:if>
			$('#frmSearch').find('select[name=listCount]').val(listCountValue);
		});	
		
		// 상세페이지 이동
		function goDetail(boardNo) {
			$('#boardNo').val(boardNo);
			$('#frm').submit();
		}
		
		// 페이징 이동
		function goPaging(page) {
			$('#morePage').val(0);
			$('#page').val(page);
			$('#frmSearch').submit();
		}
		
		// 이전으로 이동
		function goPrev(page) {
			$('#page').val(page);
			$('#frmSearch').submit();
		}
		
		// 다음으로 이동
		function goNext(page) {
			$('#page').val(page);
			$('#frmSearch').submit();
		}
		
		// 더보기
		function goMore(morePage) {
			if ($('#totalCount').val() <= $('#morePage').val()) {
				alert("마지막행입니다.");
				return;
			}
			$('#morePage').val(morePage);
			$('#frmSearch').submit();
		}
		
		</script>
	</body>
</html>
