<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>import 태그 연습</title>
</head>
<body>
<c:import url="imported.jsp" var="url">
	<c:param name="username">을지문덕</c:param>
</c:import>
<h3>import 태그 연습</h3>
<pre>
<c:out value="${url}" escapeXml="false"></c:out>
</pre>
</body>
</html>