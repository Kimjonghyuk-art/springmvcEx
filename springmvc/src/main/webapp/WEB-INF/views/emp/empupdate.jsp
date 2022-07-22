<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empInsert.jsp</title>
</head>
<body>

<h3>사원수정</h3>
<c:set var="path" value="<%=request.getContextPath()%>" />
<form action="${path}/empupdate" method="POST">
	<!-- <div>employeeId</div><input type="text" name="employeeId"> -->
	<div>employeeId</div><input type="text" name="employeeId" value="${emp.employeeId}" readOnly="readonly" >
	<div>firstName</div><input type="text" name="firstName" value="${emp.firstName}" >
	<div>lastName</div><input type="text" name="lastName"value="${emp.lastName}" >
	<div>email</div><input type="email" name="email" value="${emp.email}">
	<div>hireDate</div><input type="date" name="hireDate" 
					value='<fmt:formatDate value="${emp.hireDate}" pattern="yyyy-MM-dd"/>'>
	<div>jobId</div><input type="text" name="jobId" value="${emp.jobId}">	
	<!-- <input type="email" name="email" > -->
	
	<button>수정</button>
	<button type="button" id="btnDelete">삭제</button>
</form>

<script>
	btnDelete.addEventListener("click", function() {
		location.href="${path}/empDelete?employeeId=${emp.employeeId}";
	})
	

</script>
</body>
</html>