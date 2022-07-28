<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>EL 내장객체 </h3>
<%
	request.setAttribute("name", "request");
	session.setAttribute("name", "session");
	application.setAttribute("name", "이름");
	request.setAttribute("list", Arrays.asList("park","kim","lee"));
%>

<ul>
	<li>===파라미터===</li>
	<li><%= request.getParameter("id") %></li>
	<li>${param.id}</li>
	<li>${param["id"]}</li>
	
	<li>====속성====</li>
	<li><%= request.getAttribute("name") %></li>
	<li>${name}</li>
	<li>${sessionScope.name}</li>
	<li>${applicationScope.name}</li>
	
	<li>====헤더====</li>
	<li><%= request.getHeader("User-Agent") %></li>
	<li>${header["User-Agent"]}</li>
	
	
	<li>====쿠키====</li>
	<li>${cookie.koko.value}</li>
	
	<li>====초기화파라미터 =====</li>
	<li><%= application.getInitParameter("contextConfigLocation") %></li>
	<li>${initParam.contextConfigLocation}</li>
	
	<li>====EL 함수====</li>
	<li>리스트 크기 : ${fn:length(list)}</li>
	<li>r로 시작? : ${fn:startsWith(name, "r")}</li>
	
	<li><c:out escapeXml="true" value="<u>태그</u>" /></li>
	<li><c:out escapeXml="false" value="<u>태그</u>" /></li>
	
	
	
</ul> 


</body>
</html>