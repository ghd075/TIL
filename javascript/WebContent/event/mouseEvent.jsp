<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mouseEvent.jsp</title>
<style type="text/css">
div {
width: 300px;
height: 300px;
border : 1px solid red;
}
</style>
<script>
//마우스 클릭시 호출
window.onload = function(){
    document.getElementById("div1").addEventListener("click", mouseHandler);
    document.getElementById("div2").addEventListener("click", mouseHandler);
}
//마우스포인터가 이동할 때마다 호출
/* window.onload = function(){
    document.getElementById("div1").addEventListener("mousemove", mouseHandler);
} */
function mouseHandler(){
    //마우스 좌표값 출력
    console.log(event.clientX + " : " + event.clientY);
 	//화면 좌표값 출력
    console.log(event.screenX + " : " + event.screenY); 
    //console.log(event); //해당되는 이벤트객체와 관련된 메소드를 확인할 수 있다.
    console.log(event.target.innerHTML); //이벤트 발생한 대상(태그)
    //event.target == this와 같은 의미
    console.log("마우스 버튼 : " + event.button); //event.which, mousemove를 통해서 마우스의 드래그를 인식할 수 있음
}
</script>
</head>
<body>
<h3>마우스 이벤트 연습</h3>
<div id="div1">first</div>
<div id="div2">second</div>
</body>
</html>