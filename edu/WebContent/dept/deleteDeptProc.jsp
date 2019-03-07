<%@page import="com.edu.emp.DeptDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <jsp:useBean id="bean" class="com.edu.emp.DeptBeans"/>
 <jsp:setProperty property="*" name="bean"/>
<%
	//삭제처리페이지 : deleteDeptProc.jsp
	DeptDAO.getInstance().deptDelete(bean.getDepartment_id());
	response.sendRedirect("selectDeptList.jsp");
%>
