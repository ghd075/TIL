<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>b.jsp</title>
</head>
<body>
B page <hr>
<%-- <% String name = request.getParameter("name");
   out.print(URLDecoder.decode(name, "utf-8"));%> --%>
<%-- <%=request.getParameter("name") %> --%>
<%
	String name = request.getParameter("name");
	out.print("pw : " + request.getParameter("pw"));
%>
</body>
</html>