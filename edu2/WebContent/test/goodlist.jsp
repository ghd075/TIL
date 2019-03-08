<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>상품목록</h4>
<form action="cartadd.jsp">
		<select name="goodno" size="5">
			<option>상품1
			<option>상품2
			<option>상품3
			<option>상품4		
		</select>	
		<button>장바구니 담기</button>
		<a href="cartlist.jsp">장바구니 보기</a>
</form>
</body>
</html>