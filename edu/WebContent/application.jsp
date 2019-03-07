<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
서버명 <%=application.getServerInfo() %><br>
버전 <%=application.getMajorVersion() + "." + application.getMinorVersion() %>
</body>
</html>