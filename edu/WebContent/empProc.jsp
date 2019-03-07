<%@page import="com.edu.emp.EmpDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//empProc.jsp : 사원등록처리 페이지
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="dto" class="com.edu.emp.EmpDTO" scope="page" />
<jsp:setProperty property="*" name="dto"/>
<%
	EmpDTO dto2;
	if(pageContext.getAttribute("dto2") != null){
		dto2 = (EmpDTO) pageContext.getAttribute("dto2");
	}else{
		dto2 = new EmpDTO();
		pageContext.setAttribute("dto2", dto2);
	}
	pageContext.setAttribute("dto2", dto2);
	dto2.setFirst_name(request.getParameter("first_name"));
	dto2.setLast_name(request.getParameter("Last_name"));
%>
<%=dto.getFirst_name() %>
<hr>
<jsp:getProperty property="last_name" name="dto"/>