<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>a.jsp</title>
</head>
<body>
A page <hr>
<% String name = "홍길동"; %>
<%--@include file="b.jsp" --%> <!-- b.jsp 소스 파일을 포함해서 컴파일해줌 -->
<c:url value="b.jsp" var="url">
	<c:param name="name"><%=name%></c:param>
</c:url>
<%-- <jsp:include page="${url}"/> --%>
<jsp:forward page="b.jsp" />
<%-- <jsp:include page="b.jsp">
	<jsp:param value="<%=URLEncoder.encode(name, \"utf-8\") %>" name="name"/>
</jsp:include> --%>
<%=request.getRealPath("/") %> <!-- 지정한 경로를 찾아준다. -->
</body>
</html>