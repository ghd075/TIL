<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% //header.jsp
//페이지 요청건수 카운터
	Integer cnt = (Integer) application.getAttribute("cnt");
	if(cnt != null){
		cnt++;
	}else{
		cnt = 0;
	}
	application.setAttribute("cnt", cnt);
	out.print("방문횟수 : " + cnt);
%>
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