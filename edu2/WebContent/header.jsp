<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% //header.jsp
	//페이지요청건수 카운터
	Integer cnt= (Integer)application.getAttribute("cnt");
	if(cnt!=null){
		cnt++;
	}else{
		cnt=0;
	}
	application.setAttribute("cnt", cnt);//cnt란 이름으로 cnt값을 저장
	out.print("방문 횟수 : "+cnt);	

%>    
    
<%
	String userid=(String)session.getAttribute("userid");
	if(userid!=null){
%>
   <%=userid %>님<a href="<%=request.getContextPath()%>/loginoutServ">로그아웃</a>   	
<%
	} else {
%>
	<a href="../login.jsp">로그인</a>
<%
	}
%>
<ul>
		<li><a href="<%=request.getContextPath()%>/employees.jsp">사원등록</a></li>
		<li><a href="<%=request.getContextPath()%>/insertMember.jsp">회원등록</a></li>
		<li><a href="<%=request.getContextPath()%>/example2.jsp">실습등록</a></li>						
</ul>