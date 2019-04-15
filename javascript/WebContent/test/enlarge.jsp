<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>enlarge.jsp</title>
<script type="text/javascript">
function enlarge() { //글자사이즈 크게
	var fs = document.getElementById("demo").style.fontSize; //10px;
	document.getElementById("demo").style.fontSize = parseInt(fs)+10+'px';
}
function ensmall() { //글자사이즈 작게
	var fs = document.getElementById("demo").style.fontSize; //10px;
	document.getElementById("demo").style.fontSize = parseInt(fs)-10+'px';
}
</script>
</head>
<body>
<h4>글자 크게</h4>
<button type="button" onclick="enlarge()">크게</button>
<button type="button" onclick="ensmall()">작게</button>
<p id="demo" style="font-size: 10px;">hello!!!</p>
</body>
</html>