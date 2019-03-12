<%@page import="java.util.ArrayList"%>
<%@page import="com.edu.emp.EmpDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>eltest.jsp</title>
</head>
<body>
<h4>파라미터</h4>
id : <%=request.getParameter("id") %> == ${param.id} == ${param["id"] } <!-- 이름있는 배열 -->
<h4>헤더</h4>
header <%=request.getHeader("User-Agent") %> == <font color="blue">${header["User-Agent"] }</font>
${header} <!-- 모든 헤더정보 보기 -->
<h4>속성읽기</h4>
request : <%=request.getAttribute("reqUsername") %> == ${reqUsername}<br> <!-- ${requestScope.reqUsername}에서 앞에 requestScope생략가능 -->
session : <%=session.getAttribute("sessionUsername") %> == ${sessionUsername}<br>
application : <%=application.getAttribute("appUsername") %> == ${appUsername}<br>
beans : <%--=((EmpDTO)session.getAttribute("emp")).getFirst_name() --%> == ${emp.first_name}<br> 
<!-- EL언어에서 'getter'가 없다고 해도 first_name은 DTO의 getter메소드이다. -->
<!-- 세션에서 저장한 emp객체가 없기 때문에 emp객체가 NULL값이 되서 에러가 발생함 -->
<h4>EL 연산자</h4>
<% ArrayList list1 = null; 
   ArrayList list2 = new ArrayList<String>();
   list2.add("바나나");
   String name = "<font color='blue'>홍길동</font>";
   
   request.setAttribute("list1", list1);
   request.setAttribute("list2", list2);
   request.setAttribute("name", name);
%>
null : ${ list1 == null } ${ list1 eq null } <br>
empty : ${ empty list2 } == <%= list2== null || list2.size()==0 %>
		${ empty name }	 ==	<%= name == null || name.length()==0 %> <br>
<h4>out tag</h4>
${name} <br>
<c:out value="${name}" escapeXml="true">
	<font color="red">이름없음</font>
</c:out>
</body>
</html>