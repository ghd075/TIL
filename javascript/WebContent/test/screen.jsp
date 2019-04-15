<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>screen.jsp</title>
<style type="text/css">
body {
	font-size: 10px;
}
div {
	font-size: 2em;
	border: 1px solid red;
	width: 32%;
	height: 100px;
	display: inline-block;
}
@media screen and (max-width: 1000px) {
	div { width: 49%; }
}
@media screen and (max-width: 500px) {
	div { width: 99%; }
	nav {display: none;}
}
@media screen and (min-width: 500px) {
	body{
		background-color: lightgreen;
	}
}
</style>
<script type="text/javascript">
	document.write("<br> 모니터 : " + screen.width + "*" + screen.height); //모니터의 해상도
	document.write("<br> window : " + window.innerWidth  + "*" + window.innerHeight); //현재 윈도우 창의 해상도	
</script>
</head>
<body>
<hr>
<nav>메뉴바</nav>
<div>A</div>
<div>B</div>
<div>C</div>
<div>D</div>
<div>E</div>
<div>F</div>
</body>
</html>