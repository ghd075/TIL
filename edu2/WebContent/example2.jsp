<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example2.jsp</title>
</head>
<body>
<%@ include file="header.jsp" %>
	<h4>jsp 스크립트 태그 연습</h4>
	<%! //변수나 메서드를 선언 
		String[] hobbies = {"독서","운동","등산","스키"};	
	%>
	<select>
		<%
			for(int i=0;i<hobbies.length;i++){
		%>
		<option><%=hobbies[i] %>
		<%
			}
		%>

	</select>
	<table border=1>
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