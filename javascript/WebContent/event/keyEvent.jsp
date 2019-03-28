<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>keyEvent.jsp</title>
<script>
window.onload = function(){
    //document.getElementById("userId").addEventListener("keydown",keydownHandler);
	window.addEventListener("keydown",keydownHandler); //윈도우창에서 keydown이벤트 호출
}
function keydownHandler(){
/*     console.log(event.keyCode); //키 코드 값
    console.log(event.ctrlKey); //Ctrl 키를 누른 경우 true반환
    console.log(event.altKey);  //Alt 키를 누른 경우 true반환 
    console.log(event); */
    console.log(event.keyCode);
    var img = document.getElementsByTagName("img")[0];
    if(event.keyCode == 37){ //왼쪽
        img.style.left = (parseInt(img.style.left) - 50) + "px";
    }else if(event.keyCode == 39){ //오른쪽
    	img.style.left = (parseInt(img.style.left) + 50) + "px";
    }else if(event.keyCode == 38){ //위쪽
    	img.style.top = (parseInt(img.style.top) - 50) + "px";
    }else if(event.keyCode == 40){ //아래쪽
    	img.style.top = (parseInt(img.style.top) + 50) + "px";
    }
}
</script>
</head>
<body>
<h3>키보드 이벤트</h3>
<input name="userId" id="userId"/>
<img src="../images/logo.gif" style="width: 50px; position: absolute; left: 400px; top: 400px;">
</body>
</html>