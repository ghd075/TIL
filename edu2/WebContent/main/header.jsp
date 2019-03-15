<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
* {
  box-sizing: border-box;
}

body {
  font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
header {
  background-color: #666;
  padding: 30px;
  text-align: center;
  font-size: 35px;
  color: white;
}

/* Create two columns/boxes that floats next to each other */
nav {
  float: left;
  width: 30%;
  height: 300px; /* only for demonstration, should be removed */
  background: #ccc;
  padding: 20px;
}

/* Style the list inside the menu */
nav ul {
  list-style-type: none;
  padding: 0;
}

article {
  float: left;
  padding: 20px;
  width: 70%;
  background-color: #f1f1f1;
  height: 300px; /* only for demonstration, should be removed */
}

/* Clear floats after the columns */
section:after {
  content: "";
  display: table;
  clear: both;
}

/* Style the footer */
footer {
  background-color: #777;
  padding: 10px;
  text-align: center;
  color: white;
}

/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
@media (max-width: 600px) {
  nav, article {
    width: 100%;
    height: auto;
  }
}
</style>
<header>
  <h2>메뉴</h2>
<c:choose>
	<c:when test="${ empty sessionScope.userid }">
		<%@include file="../member/login.jsp" %>
	</c:when>
	<c:otherwise>
		<%=session.getAttribute("userid")%>님 <a href="<%=request.getContextPath()%>/loginoutServ">로그아웃</a>
	</c:otherwise>
</c:choose>
<%
	//if(session.getAttribute("userid") == null) {
%>
	<%--@include file="../member/login.jsp" --%>
<% //} else { %>
	<%--=session.getAttribute("userid")--%><%-- 님 --%> 
<% //} %>
</header>
<section>
  <nav>
    <ul>
      <li><a href="../main/main.jsp">메인</a></li>
      <li><a href="../member/selectMemberList.jsp">회원관리</a></li>
      <li><a href="../emp/selectEmpList.jsp">사원관리</a></li>
      <li><a href="../dept/SelectDept">부서관리</a></li>
      <li><a href="../board/selectBoardList.jsp">게시판관리</a></li>
    </ul>
  </nav>
  <article>