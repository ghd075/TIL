<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>window.jsp</title>
<script>
var newWin;
//윈도우 창 닫기
function win_close() {
	newWin.close();	
}
//윈도우 창 열기
function win_open() {
	//window.open("http://www.naver.com","naver", "width=100, height=100, left=200, top=200")
	newWin = window.open("findaddr.jsp","naver","width=100, height=100,left=200,top=200");
}
</script>
</head>
<body>
<button type="button" onclick="win_open()">새창열기</button>
<button type="button" onclick="win_close()">창닫기</button>
</body>
</html>