<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>date.jsp</title>
</head>
<body>
<h4>날짜 출력</h4>
<script type="text/javascript">
	var today = new Date();
	document.write(today+"<br>");
	document.write(today.getFullYear() + "년 <br>");
	//월, 일, 요일 출력
	var num = today.getMonth()+1;
	document.write(num+"월 <br>");
	document.write(today.getDate()+"일 <br>");
	switch (today.getDay()) {
	case 0:
		document.write("일요일 <br>");
		break;
	case 1:
		document.write("월요일 <br>");
		break;
	case 2:
		document.write("화요일 <br>");
		break;
	case 3:
		document.write("수요일 <br>");
		break;
	case 4:
		document.write("목요일 <br>");
		break;
	case 5:
		document.write("금요일 <br>");
		break;
	case 6:
		document.write("토요일 <br>");
		break;
	case 7:
		document.write("일요일 <br>");
		break;
	default:
		break;
	}
	
</script>
</body>
</html>