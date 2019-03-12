<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>url.jsp</title>
</head>
<body>
<h4>url 태그 연습</h4>
<%
	String search = "홍길동";
%>
<a href="selectEmpList.jsp?first_name=<%=search%>&department_id=10">사원조회</a><br>
<c:url value="selectEmpList" var="linkurl">
	<c:param name="first_name"><%=search %></c:param>
	<c:param name="department_id">10</c:param>
</c:url>
<a href="${linkurl}">사원조회</a>
</body>
</html>