<%@page import="com.edu.common.Paging"%>
<%@page import="com.edu.emp.EmpDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.edu.emp.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectEmpPaging.jsp</title>
</head>
<body>
<%
	String sp = request.getParameter("p");
	int p = 1;
	if(sp != null && !sp.isEmpty() ){
		p = Integer.parseInt(sp);
	}
	
	Paging paging = new Paging();
	paging.setPage(p); //현재페이지
	int cnt = EmpDAO.getInstance().count();
	
	paging.setPageUnit(5);
	paging.setPageSize(3);
	paging.setTotalRecord(cnt); //전체 레코드 건수
	int first = paging.getFirst();
	int last = paging.getLast();
	
	//첫번째 레코드 건수와 마지막 레코드 건수 계산 공식
	//int first = (p-1)*10+1;
	//int last = first+10-1;
	
	List<EmpDTO> list = EmpDAO.getInstance().selectPage(first, last);
%>
<table>
<c:forEach items="<%=list %>" var="emp">
	<tr><td>${emp.employee_id}</td> <td>${emp.first_name}</td> <td>${emp.email}</td></tr>
</c:forEach>
</table>
<my:paging paging="<%=paging%>" jsfunc="goList" />
<script>
	function goList(p){
		location = "selectEmpPaging.jsp?p=" + p;
	}
</script>
<style>
	li { display: inline-block; border: 1px solid gray; padding: 5px; }
	.active { color:red; }
</style>
</body>
</html>