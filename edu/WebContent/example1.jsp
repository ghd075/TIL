<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example1.jsp</title>
</head>
<body>
<!--  html 주석 -->
<%
	//라인주석
	/*
		블록주석
	*/
	String name = request.getParameter("name");
	if(name == null){
		name = "guest";
	}
%>
<%= name %> <% out.print(name); %>
<%-- jsp 주석 --%>
</body>
</html>