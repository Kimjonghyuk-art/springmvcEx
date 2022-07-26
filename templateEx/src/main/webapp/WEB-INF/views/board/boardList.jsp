<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="//cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css"
	rel="stylesheet" />
<script src="//cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
</head>

<script>
	$(function() {
		/* 	$('#myTable').DataTable(); */
		function goPage(num) {
			searchForm.pageNum.value = num;
			searchFrm.submit();
			/* location.href="boardList?pageNUm="+num */
		}

	})
</script>

<body>
	<h3>게시판 리스트</h3>
	
	<div class='row'>
		<div class="col-lg-12">
			<form name="searchForm">
				<select name='type'>
					<option value="">--</option>
					<option value="title">제목</option>
					<option value="content">내용</option>
					<option value="writer">작성자</option>
				</select>
				<input type='text' name='keyword' />
				<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
				<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
				<button class='btn btn-default'>Search</button>
			</form>
		</div>
	</div>
	
	<table class="table table-striped table-hover">
		<thead>
			<tr>
				<th>게시물 번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일시</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="b" items="${boardList}">
				<tr onclick="location.href='get?bno=${b.bno}'">
					<td>${b.bno}</td>
					<td>${b.title}</td>
					<td>${b.writer}</td>
					<td><fmt:formatDate value="${b.regdate}" pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<c:if test="${pageMaker.prev}">
				<li class="page-item">
				<a class="page-link" href="boardList?pageNum=${pageMaker.startPage-1}">Previous</a>
				</li>
			</c:if>
			
			<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
				<li class="page-item ${pageMaker.cri.pageNum == num ? 'active':''}">
				<a class="page-link" href="boardList?pageNum=${num}">${num}</a>
				</li>
			</c:forEach>
		
			<c:if test="${pageMaker.next}">
				<li class="page-item">
				<a class="page-link" href="boardList?pageNum=${pageMaker.endPage+1}">Next</a></li>
			</c:if>
		</ul>
	</nav>

	<div id="btnContainer">
		<button type="button" onclick="location.href='boardInsert'">게시물
			등록</button>
	</div>

</body>
</html>