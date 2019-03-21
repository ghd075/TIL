<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>intervalClock.jsp</title>
</head>
<body>
<div id="demo"></div>
<script>
function disp() {
	//div 태그에 시간을 출력
	var cur = new Date();
	document.getElementById("demo").innerHTML = cur.getHours() + ":" + cur.getMinutes() + ":" + cur.getSeconds();
}
setInterval(disp,1000); //타이머 해제
//(window).setInterval(disp,1000)에서 window는 생략 가능, setInterval(함수명,시간)에서 함수명은 '()'를 빼야 함
</script>
</body>
</html>