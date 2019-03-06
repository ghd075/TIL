<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>example9.jsp</title>
</head>
<body>
<%!  //선언문(메서드나 변수) - 자바코드
public int sum(int a, int b){
	return a + b;
}
%>
<%= sum(10,20) %><br>
<%= sum(100,20) %><br>
</body>
</html>