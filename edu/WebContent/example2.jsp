<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp 스크립트 태그 연습</title>
</head>
<body>
	<h4>jsp 스크립트 태그 연습</h4>
	<table border="1">
		<%
			for (int j = 0; j < 5; j++) {
		%>
		<tr>
			<%
				for (int i = 1; i <= 10; i++) {
			%>
			<td><%=i%></td>
			<%
				}
			%>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>