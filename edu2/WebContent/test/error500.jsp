<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%-- isErrorPage 값이 true값으로 설정해줘야 함  --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error500.jsp</title>
</head>
<body>
에러내용: <%= exception.getMessage() %><br>
관리자에게 문의하세요 : Tel. 053.421.2460
</body>
</html>