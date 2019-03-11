<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
${header}
</body>
</html>