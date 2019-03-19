<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>variable.jsp</title>
<script type="text/javascript">
function getName() {
	name = '김길동'; //함수 안에서 var생략하면 전역변수로 인식
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