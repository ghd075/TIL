<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session.jsp</title>
</head>
<body>
<% session.setMaxInactiveInterval(20); %> <br> <!-- 초단위 -->
session id : <%=session.getId() %> <br>
session 생성 시간 : <%=session.getCreationTime() %> 
<%
	Calendar calendar = Calendar.getInstance();
	calendar.setTimeInMillis(session.getCreationTime());
	out.print(calendar.getTime());
%><br>

마지막 접근시간 : <%=session.getLastAccessedTime() %><br>
<%
	Date date = new Date(session.getLastAccessedTime());
	out.print(date);
%><br>
세션 유지시간 : <%=session.getMaxInactiveInterval() %><br>
</body>
</html>