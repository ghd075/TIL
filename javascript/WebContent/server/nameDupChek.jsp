<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//int a = 5/0;
	Thread.sleep(1500);
	String name = request.getParameter("name");
	if(name.equals("admin")){
		out.print("사용불가");
	}else{
		out.print("사용가능");
	}
%>
