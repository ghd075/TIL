<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forToken.jsp</title>
</head>
<body>
<% String hobbys = "소설/인문/정치";  %>
<c:forTokens items="<%=hobbys %>" delims="/" var="token" varStatus="st">
	${st.count} ${token} <br>
</c:forTokens>
<c:set var="birth" value="80-12-05"/>
<c:forTokens items="${birth}" delims="-" var="token2" varStatus="t">
	 ${token2}	
	<c:choose>
		<c:when test="${t.count==1}">년</c:when>
		<c:when test="${t.count==2}">월</c:when>
		<c:when test="${t.count==3}">일</c:when>
	</c:choose>
</c:forTokens>
</body>
</html>