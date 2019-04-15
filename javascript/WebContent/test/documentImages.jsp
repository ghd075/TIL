<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Document</title>
<script>
    window.onload = function(){
      var a = document.links;
      for(i=0; i<a.length; i++){
        //href 속성을 div 태그에 출력
    	document.getElementById("demo").innerHTML += a[i].href+"<br>";
      }
    }  
</script>
</head>
<body>
<a href="#">자바</a>
<a href="#">JSP</a>
<a href="#">스프링</a>
<div id="demo"></div>
</body>
</html>