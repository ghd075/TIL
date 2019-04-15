<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>variable.jsp</title>
<script type="text/javascript">
"use strict";
function getName() {
	const x = 10; //상수선언, 변경불가
	x = 5;s
	{
	var name = '김길동'; //함수 안에서 var생략하면 전역변수로 인식
	//var x = 2; //function 기반
	let x = 2; //block 기반
	}
	console.log(x);
}
function getName2() {
	console.log(name);
}
getName();
getName2();
</script>
</head>
<body>
<h4>변수 선언</h4>
</body>
</html>