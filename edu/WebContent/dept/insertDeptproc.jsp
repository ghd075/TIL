<%@page import="com.edu.emp.DeptDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 등록처리 페이지 --%>
<%
	//한글인코딩
	request.setCharacterEncoding("utf-8");
 %>
 <jsp:useBean id="bean" class="com.edu.emp.DeptBeans"/>
 <jsp:setProperty property="*" name="bean"/>
 <%
 	DeptDAO.getInstance().deptInsert(bean);
 	response.sendRedirect("selectDeptList.jsp");
 %>  