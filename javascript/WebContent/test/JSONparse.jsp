<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSONparse.jsp</title>
<script>
	var emp = {emp_id : 100, first_name : '홍길동', email : 'ch@na.com'};
	var str = JSON.stringify(emp);
	
	document.write(typeof emp + "<br>");
	document.write(emp + "<hr>");
	
	document.write(typeof str + "<br>");
	document.write(str + "<hr>");
	
	//String -> Object
	var obj = JSON.parse(str);
	document.write(obj.email + "<hr>");
</script>
</head>
<body>
<h4>String object 변환</h4>
</body>
</html>