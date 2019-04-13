<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head><title>timer_imageSliser.jsp</title>
<script>
//이미지 배열 선언
var arrImage =  ["images/logo.gif",     "images/pic1.jpg",
                 "images/pic2.jpg",     "images/pic3.jpg"]; 
                 
var pos = 0 ; // 이미지 위치 인덱스
var timer; //타이머 변수 선언

function init(){
	document.getElementById("slider").src= "./"+arrImage[0];
	//타이머 생성(500=0.5초 동안)
	timer = setInterval(to_Right, 500);
}
function to_Right() {
	//인덱스 증가
	pos++;
	//pos 체크(이미지가 들어있는 인덱스 위치가 이미지 배열크기보다 크면 0으로 초기화)
	if(pos > (arrImage.length-1)){
		pos = 0;
	}	
	//이미지 변경
	document.getElementById("slider").src= "./"+arrImage[pos];
}

function to_Left() {
	//pos 감소
	pos--;
	//pos 체크(이미지가 들어있는 인덱스 위치가 0보다 작으면 이미지 배열 크기로 초기화)
	if(pos < 0){
		pos = arrImage.length-1;
	}
	//이미지 변경
	document.getElementById("slider").src= "./"+arrImage[pos];
}
function moveStop() {
	clearInterval(timer); //타이머 해제
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
<input type="button" value="중지" onclick="moveStop()"/>
</body>
</html>