<%@page import="com.edu.emp.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//empProc2.jsp : 사원등록
	%>
	<jsp:useBean id="dto" class="com.edu.emp.EmpDTO"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		int r = EmpDAO.getInstance().insert(dto);
		out.print(r + "건이 등록됨");
	%>
</body>
</html>