<%@page import="com.edu.emp.EmpDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>eltest.jsp</title>
</head>
<body>
<h4>파라미터</h4>
id : <%=request.getParameter("id") %> == ${param.id} == ${param["id"] } <!-- 이름있는 배열 -->
<h4>헤더</h4>
header <%=request.getHeader("User-Agent") %> == <font color="blue">${header["User-Agent"] }</font>
${header} <!-- 모든 헤더정보 보기 -->
<h4>속성읽기</h4>
<%=request.getAttribute("reqUsername") %> == ${reqUsername}<br>
<%=session.getAttribute("sessionUsername") %> == ${sessionUsername}<br>
<%=application.getAttribute("appUsername") %> == ${appUsername}<br>
<%=((EmpDTO)session.getAttribute("emp")).getFirst_name() %> == ${emp.first_name}<br>
</body>
</html>