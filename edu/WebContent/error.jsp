<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error.jsp</title>
</head>
<body>
	<h4>다음과 같은 에러가 발생하였습니다.</h4>
	에러타입 : <%=exception.getClass().getName() %>
	<br> 에러메시지 : <%=exception.getMessage() %>
	<br> 관리자에게 문의 tel:053-211-2222
</body>
</html>