<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>splitTest.jsp</title>
<script type="text/javascript">
	var str = '1월, 2월, 3월';
	var months = str.split(",");
	for(i=0; i<months.length; i++){
		document.write(months[i] + "<br>");
	}
	// 배열 -> string
	var arr = ["사과", "배", "딸기"];
	document.write(arr.length + "<br>"); //배열 요소의 갯수를 반환
	
	var str = arr.join(); //string
	document.write(str.length + "<br>"); //배열 요소의 데이터 길이를 다 합쳐서 반환
</script>
</head>
<body>
<h4>split test</h4>
</body>
</html>