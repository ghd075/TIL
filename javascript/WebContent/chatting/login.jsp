<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("user");
%>
<result>
	<code>success</code>
	<nickName><%= id %></nickName>
</result>