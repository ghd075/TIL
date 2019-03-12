<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<sql:query var="rs" dataSource="jdbc/oracle">
	select * from employees
</sql:query>
<table border="1">
<c:forEach items="${rs.rows}" var="row">
	<tr>
		<td>${row.employee_id}</td>
		<td>
		${row.first_name}
		</td>
		<td>
			<fmt:formatDate value="${row.hire_date}" pattern="yyyy/MM" />
		</td>
		<td>
			<fmt:formatNumber type="number" value="${row.salary}"/>
		</td>
		<td>
			<c:choose>
				<c:when test="${row.salary>=10000}">상</c:when>
				<c:when test="${row.salary>=5000}">중</c:when>
				<c:otherwise>하</c:otherwise>
			</c:choose>
		</td>
		<td>
			<c:choose>
				<c:when test="${empty row.manager_id}">없음</c:when>
			</c:choose>
			${row.manager_id}</td>
		<td>
			<c:choose>
				<c:when test="${empty row.department_id}">없음</c:when>
			</c:choose>
		${row.department_id}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>