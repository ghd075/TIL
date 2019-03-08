<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cartlist.jsp</title>
</head>
<body>
<h4>장바구니리스트</h4>
<%
	List<String> cartlist=(List<String>)session.getAttribute("cart");
	for(int i=0; i<cartlist.size();i++){
		out.print(cartlist.get(i)+"<br>");
	}
%>
</body>
</html>