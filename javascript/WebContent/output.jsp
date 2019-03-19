<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>output.jsp</title>
</head>
<body>
<h4>자바스크립트 출력 테스트</h4>
<p id="demo"></p>

<script>
	document.getElementById("demo").innerHTML = '태그 내용 변경';
	document.write("<p>write로 출력</p>"); //out.print()와 똑같은 기능 수행
	window.alert("알림페이지 출력");
	console.log("콘솔 출력"); //System.out.print()와 똑같은 기행 수행
</script>
</body>
</html>