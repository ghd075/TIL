<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deptList.jsp</title>
</head>
<body>
<form action="deptList.do" method="post">
<table border="1">
	<tr>
		<td>부서번호</td> <td>부서명</td> <td>지역</td> <td>매니저</td>	
	</tr>
	<c:forEach items="${list}" var="dept">
		<tr>
			<td>${dept.department_id}</td> <td>${dept.department_name}</td> 
			<td>${dept.location_id}</td> <td>${dept.manager_id}</td>	
		</tr>
	</c:forEach>
</table>
</form>
</body>
</html>