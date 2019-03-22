<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>function10.jsp</title>
<script type="text/javascript">
	//객체생성자함수를 이용하여 클래스 선언(자바의 클래스 정의(public))
	function Calc(a, b) { //Calc(a, b) 생성자
		//해당 객체의 필드멤버 선언()
		this.a = a; //int a;
		this.b = b; //int b;
		this.result = a + b; //int result = a + b;
		this.getResult = function() { //int getResult()
			return this.result; //return result;
		}
	}
	//객체 생성(자바의 객체 인스턴스)
	c = new Calc(10,20); //Calc c = new Calc(10,20)
	document.write(c.getResult);
</script>
</head>
<body>
<h3>클래스(객체) 선언</h3>
</body>
</html>