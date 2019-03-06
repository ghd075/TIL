<%@page import="com.edu.dept.DeptDTO"%>
<%@page import="com.edu.dept.DeptDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectDept.jsp</title>
</head>
<body>
<%
	DeptDTO dto = new DeptDTO();
	dto.setDepartment_id(request.getParameter("deptid"));
	DeptDTO dept = DeptDAO.getInstance().selectOne(dto);
	out.print(dept.getDepartment_id() + "<br>");
	out.print(dept.getDepartment_name() + "<br>");
%>
	
</body>
</html>