<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title> table_data.jsp </title>
<script>
	var num = 1;
	var t = "<table border='1'>";
	for(var i = 1; i <= 5 ; i++) {
		t += "<tr>";
		for(var k = 1; k <= 5 ; k++) {
			t += "<td>" + num + "</td>";
			num++;
		}
		t += "</tr>";
	}
	t += "</table>";

	document.write(t);
</script>
</head>
<body>
</body>
</html>