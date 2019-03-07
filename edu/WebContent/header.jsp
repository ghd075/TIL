<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = (String)session.getAttribute("userId");
	if(userId != null){
%>
		<%=userId%>님 <a href="loginProc.jsp">로그아웃</a>
<% } else { %>
	<a href="login.jsp">로그인</a>
<% } %>
<ul>
	<li><a href="employess.jsp">사원등록</a></li>
	<li><a href="insetMember.jsp">회원등록</a></li>
	<li><a href="example2.jsp">실습</a></li>
</ul>