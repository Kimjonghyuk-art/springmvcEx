<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>사원 리스트</h3>

<form>
	사원번호<input name="employeeId">
	
	부서번호<input type="checkbox" name="depts" value="10">10
	<input type="checkbox" name="depts" value="20">20
	<input type="checkbox" name="depts" value="50">50
	
	직무<select name="jobId">
		<option value="">선택
		<option value="AD_PRES">AD_PRES
		<option value="AD_VP">AD_VP
		<option value="AD_ASST">AD_ASST
		<option value="IT_PROG">IT_PROG
	</select>
	
	 입사일자 <input type="date" name="sdt">~<input type="date" name="edt">  
	<button>검색</button>
</form>

<table class="table table-striped table-hover">
	<tr>
		<th>employee_id</th>
		<th>first_name</th>
		<th>last_name</th>
		<th>email</th>
		<!-- <th>phone_number</th> -->
		<th>hire_date</th>
		<th>job_id</th>
		<th>salary</th>
	<!-- 	<th>commission_pct</th>
		<th>manager_id</th>
		<th>department_id</th> -->
	</tr>
<c:forEach items="${empList}" var="emp">
<tr>
<td><a href="empupdate/${emp.employeeId}">${emp.employeeId}</a></td>
<td>${emp.firstName}</td>
<td>${emp.lastName}</td>
<td>${emp.email }</td>
<td><fmt:formatDate value="${emp.hireDate}" pattern="yyyy-MM-dd"/></td>
<td>${emp.jobId }</td>
<td>${emp.salary }</td>

</tr>
	
</c:forEach>

</table>
</body>
</html>