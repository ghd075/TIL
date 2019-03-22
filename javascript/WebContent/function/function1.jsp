<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>function1.jsp</title>
<script type="text/javascript">
	var count = 0; //카운터 변수 선언
	
	//함수호출(실행)
	myfunc();

  	//함수선언(정의)
	function myfunc() {
		count++;
		document.write("hello"+count+"<br>");
	}
	
	document.write("<hr>");
  	//익명함수 선언해서 변수에 지정
  	var myfunc2 = function(){
  		count++;
  		document.write("myfunc2"+count+"<br>");
  	}
  	//함수호출
  	myfunc2();
</script>
</head>
<body>
</body>
</html>