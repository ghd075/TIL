<%@page import="com.edu.emp.DeptBeans"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.edu.emp.DeptDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectDeptList.jsp</title>
</head>
<body>
<h4>부서목록</h4>
<a href="insertDept.jsp">부서등록</a>
<table>
	<tr><td>부서번호</td><td>부서명</td><td>지역</td><td>매니저</td></tr>
<%
	ArrayList<DeptBeans> list = DeptDAO.getInstance().selectAll();
	for(int i = 0; i<list.size(); i++){
		DeptBeans beans = list.get(i);
%>
	<tr>
		<td>
		<a href="updateDept.jsp?department_id=<%=beans.getDepartment_id()%>"><%=beans.getDepartment_id()%>
		</a></td>
		<td><%=beans.getDepartment_name() %></td>
		<td><%=beans.getLocation_id() %></td>
		<td><%=beans.getManager_id() %></td>
	</tr>
<%} %>
</table>
</body>
</html>