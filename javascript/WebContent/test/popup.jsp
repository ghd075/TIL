<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>popup.jsp</title>
<script src="js/cookie.js"></script>
<script>
function changePopup(obj) {
	if(obj.checked == true){
		//setCookie("popup", "N", 1); //쿠키에 저장
		sessionStorage.setItem("popup","N"); //세션에 저장
	}
}
</script>
</head>
<body>
<h4>광고팝업</h4>
<input type="checkbox" onclick="changePopup(this)">오늘은 이 창 열지 않기
</body>
</html>