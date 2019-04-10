<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>innerHTMLTest.jsp</title>
<style>
	div { border: 1px blue solid; height: 50px;}
</style>
<script>
	var cnt = 0;
	var yes_cnt = 0;
	var no_cnt = 0;
	function sum() {
		cnt++;
		num1 = document.getElementById("num1").value;
		num2 = document.getElementById("num2").value;
		result = document.getElementById("result").value;
		var num3 = parseInt(num1) + parseInt(num2);
		//num1+num2 와 result 같으면 "맞다" 출력 아니면 "틀리다" 출력 (if else)
		if(result == String(num3)){
			document.getElementById("demo").innerHTML = "정답";
			yes_cnt++;
		}else{
			document.getElementById("demo").innerHTML = "오답";
			no_cnt++;
		}
		//div 태그에 결과 출력
		//document.getElementById("demo").innerHTML = parseInt(num1) + parseInt(num2);
		
		//숫자 랜덤
		document.getElementById("num1").value = Math.floor(Math.random() * 10);
		document.getElementById("num2").value = Math.floor(Math.random() * 10);
		document.getElementById("result").value = "";
		//cnt가 10회 이상이면 틀린 수, 맞은갯수를 출력하고 버튼은 비활성화
		if(cnt >= 10){
			document.getElementById("demo").innerHTML = "맞는 횟수 : " + yes_cnt + " 틀린 횟수 : " + no_cnt;
			document.getElementById("btn").disabled = true;
			alert("게임 오버입니다.");
		}
	}
	
	function gamestart() {
		//변수 초기화
		cnt = 0;
		yes_cnt = 0;
		no_cnt = 0;
		//num1, num2 난수 출력
		document.getElementById("num1").value = Math.floor(Math.random() * 10);
		document.getElementById("num2").value = Math.floor(Math.random() * 10);
		//div 태그 내용 삭제
		document.getElementById("demo").innerHTML = "";
		document.getElementById("btn").disabled = false;
	}
</script>
</head>
<body>
<input id="num1" value="10" /> + <input id="num2" value="20" /> =
<input id="result" value="" />
<button type="button" onclick="sum()" id="btn">결과확인</button>
<button type="button" onclick="gamestart()" id="btn">게임초기화</button>
<div id="demo"></div>
</body>
</html>