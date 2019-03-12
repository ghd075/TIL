<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>total.jsp</title>
</head>
<body>
<%
	int sum=0;
	for(int i=0; i<=10; i++){
		sum = sum+i;
	}
	out.print(sum);
%>
<c:set var="sum" value="0"/>
<c:forEach var="i" begin="1" end="10">
	<c:set var="sum" value="${sum+i}"/>
	<br>
	<c:out value="${i}"/>
</c:forEach>
<br>
합계 : <c:out value="${sum}"/>
</body>
</html>