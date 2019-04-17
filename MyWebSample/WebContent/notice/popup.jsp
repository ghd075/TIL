<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>popup.jsp</title>
<script src="js/cookie.js"></script>
<script>
function changePopup(obj){
	if(obj.checked == true) {
		setCookie("popup1", "N", 1);  		//쿠키에 저장
		
	}
}
</script>
</head>
<body>
광고팝업<input type="checkbox" class="btn btn-info" onclick="changePopup(this)">오늘은 이 창 열지 않기
</body>
</html>