<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scriptTest.jsp</title>
<style>
	img { width: 200px }
</style>
<script>
	function mouseoverHandler(){
		document.getElementById("img1").src="./images/pic2.jpg";
	}
	function mouseoutHandler() {
		document.getElementById("img1").src="./images/pic1.jpg";
	}
</script>
</head>
<body>
<img id="img1" src="./images/pic1.jpg"
	 onmouseover="mouseoverHandler();"
	 onmouseout="mouseoutHandler();"
	 />
</body>
</html>