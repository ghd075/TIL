<%@page import="com.edu.emp.EmpDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>속성 저장</h3>
<%--
	application.setAttribute("appUsername", "홍길동");
	session.setAttribute("sessionUsername", "김길동");
	request.setAttribute("reqUsername", "박길동");
	session.setAttribute("emp", new EmpDTO("100","사원김유신","2000"));
--%>
<c:set var="appUsername" value="홍길동" scope="application"/>
<c:set var="sessionUsername" value="김길동" scope="session"/>
<c:set var="reqUsername" value="박길동" scope="request"/>
<c:set var="emp" value="<%=new EmpDTO()%>" scope="session"/>
<c:set value="사원유관순" target="${emp}" property="first_name"/>
<jsp:forward page="eltest.jsp"/>
</body>
</html>