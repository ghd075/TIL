<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>eventBubblue.jsp</title>
<style type="text/css">
	div {
		margin: 100px;
		border: 1px solid blue;
	}
</style>
<script>
/* function init(){
    alert('방가');
} */
function init(){
    var grand = document.getElementById("grand");
    var parent = document.getElementById("parent");
    var child = document.getElementById("child");
    
    //자식태그를 클릭시 자식태그과 연결된 이벤트를 실행하고 부모태그를 찾아가서 관련 부모태그과 연결된 이벤트도 실행함
    grand.addEventListener("click",function(){alert("grand click!");})
    parent.addEventListener("click",function(){alert("parent click!");})
    child.addEventListener("click",function(){alert("child click!");})
}

window.addEventListener("load",init);

/* window.onload = function(){
    alert('방가');
} */	
</script>
</head>
<body>
<h3>이벤트 전파(propergation)</h3>
<div id="grand">할아버지
	<div id="parent">아버지
		<div id="child">손자
		</div>
	</div>
</div>
</body>
</html>