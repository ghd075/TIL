<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>속성 읽기</h3>
<%
	out.print("application: "+application.getAttribute("appUsername")+"<br>");
	out.print("session: "+session.getAttribute("sessionUsername")+"<br>");
	out.print("request: "+request.getAttribute("reqUsername")+"<br>");
%>
</body>
</html>