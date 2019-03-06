<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="error.jsp"
    trimDirectiveWhitespaces="true"
    buffer="8kb"
    autoFlush="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example1.jsp</title>
</head>
<body>
<!--  html 주석 -->
<%
	Date today;
	//int a = 5/0;
	//라인주석
	/*
		블록주석
	*/
	String name = request.getParameter("name");
	if(name == null){
		name = "guest";
	}
	for(int i=0; i<500;i++){
%>
	<%= name %> <% out.print(name); %>
<% } %>
<%-- jsp 주석 --%>
</body>
</html>