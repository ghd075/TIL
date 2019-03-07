<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<%
	String msg = (String)request.getAttribute("msg");
	if(msg == null){
		msg = "";
	}
	out.print(msg);
%>
	<form action="loginProc.jsp" method="post">
		id <input name="userId"><br>
		pw <input name="userPw"><br>
		<button>로그인</button>
	</form>
</body>
</html>