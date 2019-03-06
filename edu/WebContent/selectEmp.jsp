<%@page import="java.util.List"%>
<%@page import="com.edu.emp.EmpDAO"%>
<%@page import="com.edu.emp.EmpDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectEmp.jsp</title>
</head>
<body>
<%
	//EmpDAO dao = new EmpDAO();
/* 	EmpDTO dto = new EmpDTO();
	dto.setEmployee_id(request.getParameter("employee_id"));
	EmpDTO emp = dao.selectOne(dto);
	out.print(emp.getEmployee_id() + "<br>");
	out.print(emp.getFirst_name() + "<br>");
	out.print(emp.getLast_name() + "<br>");
	out.print(emp.getEmail() + "<br>"); */
	List<EmpDTO> datas = EmpDAO.getInstance().selectAll();
	for(int i = 0; i<datas.size(); i++){
		EmpDTO emp = datas.get(i);
		out.print(emp.getEmployee_id() + ", ");
		out.print(emp.getFirst_name() + ", ");
		out.print(emp.getLast_name() + ", ");
		out.print(emp.getEmail() + "<br>");
	}
%>
</body>
</html>