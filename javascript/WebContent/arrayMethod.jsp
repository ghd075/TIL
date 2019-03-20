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