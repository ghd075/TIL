<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getCookie.jsp</title>
</head>
<body>
value : ${cookie.subject.value} <br>
maxAge : ${cookie.subject["maxAge"]}<br>  
domain : ${cookie.subject.domain} 
<br>
<%
Cookie[] list = request.getCookies();
for(int i=0; i<list.length; i++) {
	if("code".equals(list[i].getName())) { //특정쿠키 값 찾는 방법
		out.print(list[i].getValue() + "<br>");
	}
}
%>
</body>
</html>