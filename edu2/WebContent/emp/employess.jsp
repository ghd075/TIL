<%@page import="com.edu.emp.JobDAO"%>
<%@page import="com.edu.emp.DeptDAO"%>
<%@page import="com.edu.emp.DeptDTO"%>
<%@page import="com.edu.emp.JobDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 id="top">사원등록</h3>
<form action="empProc2.jsp" method="post" name="frm">
	employee_id <input type="number" min="300" step="1" name="employee_id"><br> 
	first_name <input name="fires_name"><br>
	last_name <input name="last_name"><br>
	email <input type="email" name="email"><br>
	phone_number<input name="phone_number"><br>
	hire_date<input type="date" name="hire_date"><br>
	job_id<select name="job_id">
		<%
			List<JobDTO> datas = JobDAO.getInstance().selectAll();
			for(int i = 0; i < datas.size(); i++){
				JobDTO job = datas.get(i);
		%>
			<option value="<%=job.getJob_id()%>"><%=job.getJob_title()%>
		<% } %>	
		
	<!-- 	<option value="AD_PRES">President
		<option value="AD_VP">Administration Vice President
		<option value="AD_ASST">Administration Assistant
		<option value="FI_MGR">Finance Manager -->	
	</select><br>
	department_id
	<%
		List<DeptDTO> datas2 = DeptDAO.getInstance().selectAll();
		for(int i = 0; i < datas2.size(); i++){
				DeptDTO dept = datas2.get(i);
	%>
		<input type="radio" name="department_id" value="<%=dept.getDepartment_id()%>"><%=dept.getDepartment_name()%>
		<% } %>	
<!-- 	<input type="radio" name="department_id" value="10">Administration
	<input type="radio" name="department_id" value="20" checked="checked">Marketing
	<input type="radio" name="department_id" value="30">Purchasing
	<input type="radio" name="department_id" value="40">Human Resource<br> -->
	<br>
	manager_id
	<input type="text" name="manager_id">
	<input type="text" name="name">
	<button type="button" onclick="window.open('selectEmp.jsp','emp','width=400,height=400')">사원검색</button><br>	
	
	<button type="submit">등록</button>
	<button type="reset">초기화</button>
</form>
<a href="#top">맨위로</a>
</body>
</html>

<!-- 
employee_id
first_name
last_name
email
phone_number
hire_date
job_id
salary
commission_pct
manager_id
department_id
 -->
