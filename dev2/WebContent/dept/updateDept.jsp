<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateDept.jsp</title>
</head>
<body>
<h4>부서수정</h4>
<%-- <%
	//단건조회
	String department_id = request.getParameter("department_id");
	DeptBeans beans = DeptDAO.getInstance().getDept(department_id);
	request.setAttribute("beans", beans);
%> --%>
<form action="updateDept.do" method="post">
	부서번호<input name="department_id" value="${beans.department_id}" readonly="readonly"><br>
	부서명<input name="department_name" value="${beans.department_name}"><br>
	지역<input name="location_id" value="${beans.location_id}"><br> <!-- NULL값도 자동으로 체크함  -->
	매니저<input name="manager_id" value="${beans.manager_id}"><br>
	<button type="submit">수정</button>
	<c:url value="/deleteDept.do" var="url">
		<c:param name="department_id">${beans.department_id}</c:param>
	</c:url>
	<a href="${url}">삭제</a>
</form>
</body>
</html>