<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>게시판 리스트</h3>
	<table>
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
	<div id="btnContainer">
		<button type="button" onclick="location.href='boardInsert'">게시물
			등록</button>
	</div>

</body>
</html>