<%@page import="com.jogiyo.dao.LoginDAO"%>
<%@page import="com.jogiyo.vo.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Thread.sleep(500);
	String id = request.getParameter("id");
	MemberDTO member = LoginDAO.getInstance().duplicateIdCheck(id);
	String did = member.getId();
	if(id.equals(did)){
		out.print("사용불가");
	}else{
		out.print("사용가능");
	}
%>
