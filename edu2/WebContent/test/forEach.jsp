<%@page import="java.util.ArrayList"%>
<%@page import="com.edu.emp.EmpDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forEach.jsp</title>
</head>
<body>
<%
	List<EmpDTO> list = new ArrayList<EmpDTO>();
	list.add(new EmpDTO("100","홍길동","2000"));
	list.add(new EmpDTO("101","김길동","1000"));
	list.add(new EmpDTO("102","박길동","3000"));
	request.setAttribute("list", list);
%>
<table>
<c:forEach items="${list}" var="bean" varStatus="s" begin="0" end="5"> <!-- for(EmpDTO bean : list) { -->
	<tr><td>${s.index} ${s.count}</td>
		<td>${bean.employee_id}</td>
		<td>${bean.first_name}</td>  <%--if() --%>
		<td><font color="${bean.salary>2000?"blue":"green"}">${bean.salary}</font></td></tr> <!-- =bean.getEmployee_id()  -->
</c:forEach>
</table>							<!-- } -->
<c:forEach var="i" begin="0" end="9" step="2">  <%-- for(int i=0;i<10;i++ --%>
${i} 				
</c:forEach>
</body>
</html>