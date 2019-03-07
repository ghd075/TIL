<%@page import="com.edu.emp.DeptBeans"%>
<%@page import="com.edu.emp.DeptDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateDept.jsp</title>
</head>
<body>
<h4>부서수정</h4>
<%
	//단건조회
	String department_id = request.getParameter("department_id");
	DeptBeans beans = DeptDAO.getInstance().getDept(department_id);
%>
<form action="updateDeptProc.jsp">
	부서번호<input name="department_id" value="<%=beans.getDepartment_id() %>"><br>
	부서명<input name="department_name" value="<%=beans.getDepartment_name() %>"><br>
	지역<input name="manager_id" value="<%=beans.getLocation_id()==null ? "" : beans.getLocation_id() %>"><br>
	매니저<input name="location_id" value="<%=beans.getManager_id()==null ? "" : beans.getManager_id() %>"><br>
	<button type="submit">등록</button><br>
</form>
</body>
</html>