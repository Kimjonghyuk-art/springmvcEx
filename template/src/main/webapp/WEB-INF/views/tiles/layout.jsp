<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><tiles:getAsString name="title" /></title>
<%-- <link href="<c:url value='/resources/css/layout.css' />"
	rel="stylesheet"></link> --%>
</head>
<header id="header">
	<tiles:insertAttribute name="header" />
</header>
<tiles:insertAttribute name="content" />
<%-- <footer id="footer">
	<tiles:insertAttribute name="footer" />
</footer> --%>
</body>
</html>

