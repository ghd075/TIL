<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head><title>timer_imageSliser.jsp</title>
<script>
var arrImage =  ["images/logo.gif",     "images/pic1.jpg",
                 "images/pic2.jpg",        "images/pic3.jpg"]; 
                 
var pos = 0 ; // 이미지 위치 인덱스
function init(){
	document.getElementById("slider").src= "./"+arrImage[0];
}
function to_Right() {
	

	if(pos == (arrImage.length-1)){
		pos = -1;
	}	document.getElementById("slider").src= "./"+arrImage[++pos];
}

function to_Left() {

	if(pos == 0){
		pos = arrImage.length;
	}	document.getElementById("slider").src= "./"+arrImage[--pos];
}
</script>
</head>
<body onload="init();">
<!-- imageSlider.jsp -->
이미지 슬라이더 <hr>
<img id="slider" src="" 
    style="width: 200px;height: 200px; position: relative; left: 100px;"><br>
<input type="button" value="◀" onclick="to_Left()"/> 
<input type="button" value="▶" onclick="to_Right()"/>
</body>
</html>