<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>function2.jsp</title>
<script type="text/javascript">
	var color = ['white', 'yellow', 'green', 'aqua'];
	var i = 0;
	
	function changeColor() {
		//i증가
		i++;
		//i가 배열의 원소 갯수보다 크다면 0으로 초기화
		if(i>color.length-1){
			i = 0;
		}
		document.body.style.backgroundColor = color[i];
	}
</script>
</head>
<body>
<button type="button" onclick="changeColor()">배경색바꾸기</button>
</body>
</html>