<%@page import="com.edu.emp.EmpDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>속성 저장</h3>
<%
	application.setAttribute("appUsername", "홍길동");
	session.setAttribute("sessionUsername", "김길동");
	request.setAttribute("reqUsername", "박길동");
	session.setAttribute("emp", new EmpDTO("100","사원김유신","2000"));

%>
</body>
</html>