<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>screen.jsp</title>
<style type="text/css">
div {
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
}
@media screen and (min-width: 500px) {
	body{
		background-color: lightgreen;
	}
}
</style>
<script type="text/javascript">
	document.write(screen.width + "*" + screen.height);
</script>
</head>
<body>
<hr>
<div>A</div>
<div>B</div>
<div>C</div>
<div>D</div>
<div>E</div>
<div>F</div>
</body>
</html>