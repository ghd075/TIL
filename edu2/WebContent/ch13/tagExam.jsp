<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	HashMap<String,Object> map = new HashMap<String,Object>();
	map.put("01","서울");
	map.put("02","대구");
	map.put("03","부산");
%>
<my:selectList items="<%=map%>" name="area" />
</body>
</html>