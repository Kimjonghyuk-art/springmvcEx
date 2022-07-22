<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empInsert.jsp</title>
</head>
<body>

<h3>사원등록</h3>

<form action="empInsert" method="POST">

	<!-- <div>employeeId</div><input type="text" name="employeeId"> -->
	<div>firstName</div><input type="text" name="firstName" >
	<div>lastName</div><input type="text" name="lastName" >
	<div>email</div><input type="email" name="email">
	<div>hireDate</div><input type="date" name="hireDate">
	<div>jobId</div><input type="text" name="jobId">	
	<!-- <input type="email" name="email" > -->
	
	<button>등록</button>
</form>

</body>
</html>