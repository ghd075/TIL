<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>menuTest.jsp</title>
<script>
		var menu = ["짜장면", "돈까스", "된장국", "김치찌개", "회덮밥"] ;
		var menuNum = Math.floor(Math.random()*menu.length);
		var result = menu[menuNum];
		document.write( result );
</script>
</head>
<body>

</body>
</html>