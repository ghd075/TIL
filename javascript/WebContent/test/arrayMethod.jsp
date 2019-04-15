<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>arrayMethod.jsp</title>
<script>
//var arr = ['사과','배','포도'];
//arr.push('딸기');
document.title = "title 변경"
function addSel() {
	var txt = document.getElementById("in").value;
    var parent = document.getElementById("Left");
    //option태그 생성
    var newNode = document.createElement("option");
    
    newNode.innerHTML = txt;
  	//선택한 요소 안에 자식 요소를 추가
    parent.appendChild(newNode);
  	//텍스트필드 클리어
    document.getElementById("in").value = " ";
}
function toright() {
	var index = document.getElementById("Left").selectedIndex;
	var arr1 = document.getElementById("Left").options[index];
	document.getElementById("Right").add(arr1,0);
}
</script>
</head>
<body>
<h4>배열 메서드</h4>
<input type="text" id="in" />
<button type="button" onclick="addSel()">추가</button>
<br>
<select id="Left" size="5">
	<option>사과
	<option>배
	<option>바나나
</select>
<button type="button" onclick="toright()">▶</button>
<select id="Right" size="5">
</select>
</body>
</html>