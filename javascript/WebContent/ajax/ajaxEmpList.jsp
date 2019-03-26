<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajaxEmpList.jsp</title>
<script>
var p = 0;
function loadEmp(){
    //1. 객체생성
    var xhttp = new XMLHttpRequest();
    //2.콜백함수
    xhttp.onreadystatechange = function(){
        if(xhttp.readyState == 4 && xhttp.status == 200){
        	//dom
        	  var list = JSON.parse(xhttp.responseText);
              var html = "";
              for(i=0; i<list.length;i++){
                  html += "<span>" + list[i].first_name + "</span>";
                  html += "<span>" + list[i].last_name + "</span><br>";
                  document.getElementById("demo").innerHTML += html;
              }
            //document.getElementById("demo").innerHTML += xhttp.responseText+"<hr>";
        }
    }
    //3.서버요청준비
    var param = "?p=" + (++p);
    xhttp.open("GET","../server/selectEmp.jsp"+param); //생략하면 true이다.
    //4.요청
    xhttp.send();
}
</script>
</head>
<body>
<h3>사원목록</h3>
<div id="demo"></div>
<button type="button" onclick="loadEmp()">more</button>
</body>
</html>