<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>window.jsp</title>
</head>
<body onload="init()">
<input type="text" id="addr"/>
<button type="button" onclick="win_open()">새창열기</button>
<button type="button" onclick="location='';">창닫기</button>
<script src="js/cookie.js"></script>
<script src="js/window.js"></script>   <!-- external -->

</body>
</html>