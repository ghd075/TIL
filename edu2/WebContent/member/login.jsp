<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String msg = (String) request.getAttribute("msg");
		if (msg == null) {
			msg = "";
		}
		out.print(msg);
	%>
	<form action="<%=request.getContextPath()%>/loginoutServ" method="post">
		id : <input name="userid"><br> pw : <input name="userpw"><br>
		<button>로그인</button>
	</form>
</body>
</html>