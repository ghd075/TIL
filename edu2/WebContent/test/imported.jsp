<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>imported.jsp</title>
</head>
<body>
<table border="1">
	<tr><th>인클루드</th></tr>
	<tr><td><%=request.getParameter("username") %> ${param.username}</td></tr>
</table>
</body>
</html>