<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>function10.jsp</title>
<script type="text/javascript">
	//객체생성자함수를 이용하여 클래스 선언(자바의 클래스 정의(public))
	function Calc(a, b) {  //Calc(a, b) 생성자
		//해당 객체의 필드멤버 선언()
		this.a = a;  //int a;
		this.b = b;  //int b;
		this.result = a + b;  //int result = a + b;
		//int getResult()
		this.getResult = function() {  
			return this.result; 
		}
		//return result;
	}
	//객체 생성(자바의 객체 인스턴스)
	c = new Calc(10,20);  //Calc c = new Calc(10,20)
	document.write(c.getResult());
	document.write("<hr>");
	
	function CalcBMI(w, h) {
		this.w = w;
		this.h = h/100;
		this.bmi = this.w/(this.h*this.h);
		this.getBmi = function() {
			var result = "";
			if(this.bmi <= 18.5){
				result = "저체중"
			}else if(this.bmi < 23){
				result = "정상"
			}else if(this.bmi < 25){
				result = "과체중"
			}else{
				result = "비만"
			}
			return "체중 : " + w + "<br>" +
				   "신장 : " + h + "<br>" +
					this.bmi.toFixed(2) + "<br>" + result;
		}
	}
	//var c1 = new CalcBMI(65,173);
	//document.write(c1.getBmi());
	
	function calc() {
		//텍스트 필드의 값 조회 : value
		var w = document.getElementById("w").value;
		var h = document.getElementById("h").value;
		//객체 생성
		var c1 = new CalcBMI(parseFloat(w),parseFloat(h));
		//결과를 div태그에 출력 innerHTML
		document.getElementById("demo").innerHTML = c1.getBmi();
	}
</script>
</head>
<body>
신장 : <input type="text" id="h"/>
체중 : <input type="text" id="w"/>
<button type="button" onclick="calc()">계산</button>
<div id="demo"></div>
</body>
</html>