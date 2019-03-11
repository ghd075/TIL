<%@page import="com.edu.deptBeans.DeptDAO"%>
<%@page import="com.edu.deptBeans.DeptBeans"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectDeptList.jsp</title>
</head>
<body>
<%@include file="../main/header.jsp"%>
<%-- include file="../header.jsp" --%>
<h4>부서목록</h4>
<a href="insertDept.jsp">부서등록</a>
<table>
	<tr><td>부서번호</td><td>부서명</td><td>지역</td><td>매니저</td></tr>
<c:if test="${empty list}">
	<tr><td colspan="4">조회된 데이터가 없습니다.</td>
</c:if>
<c:if test="${not empty list}">
	<c:forEach items="${list}" var="beans">
		<tr>
			<td>
			<a href="updateDept?department_id=${beans.department_id}">${beans.department_id}
			</a></td>
			<td>${beans.department_name}</td>
			<td>${beans.location_id}</td>
			<td>${beans.manager_id}</td>
		</tr>
	</c:forEach>
</c:if>
</table>
<%@include file="../main/footer.jsp"%>
</body>
</html>