<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectElement.jsp</title>
<script>
    function changeSize(){
        //var imgList = document.getElementsByTagName("img");
        //var imgList = document.getElementsByClassName("main");
        var imgList = document.querySelectorAll("img.main");
        for(i=0; i<imgList.length;i++){
            imgList[i].style.width = "200px";
        }
    }
</script>
</head>
<body>
<button type="button" onclick="changeSize()">모두크기변경</button>
<img class="main" src="../images/sky.jpg"/>
<img src="../images/pic2.jpg"/>
<img class="main" src="../images/logo.gif"/>
</body>
</html>