<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>주소검색</h4>
<a href="#" onclick="selAddr('대구')">대구</a><br>
<a href="#" onclick="selAddr('부산')">부산</a><br>
<button type="button" onclick="win_close()">창닫기</button>
<script>
function selAddr(addrText) {
	if(confirm("주소 선택할까요?")) { //참인지 거짓인지를 구분하는 판업창 출력
		opener.document.getElementById("addr").value=addrText; 
		//opener.document.getElementById() -> 부모창(window.jsp)에 값을 전달, (window).document.getElementById() -> window는 생략 가능하며 이는 현재창(findaddr.jsp)에 값을 전달
		window.close(); //window이므로 현재창(findaddr.jsp)
	}
}
function win_close() {
	window.close();
}
</script>
</body>
</html>