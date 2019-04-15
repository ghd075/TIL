<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset = "UTF-8">
<title> 함수 </title>
<script>
	function chColor() {
		var arrColor = ["#ff0", "#6c0", "#fcf", "#cf0", "#39f"];
		var arrNum = Math.floor(Math.random() * arrColor.length);
		var bodyTag = document.getElementById("theBody");
		bodyTag.style.backgroundColor = arrColor[arrNum];
	}
</script>
</head>
<body id="theBody">
    <button onclick="chColor()">배경 색상 바꾸기</button>
</body>
</html>