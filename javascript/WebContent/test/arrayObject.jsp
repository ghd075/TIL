<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>arrayObject.jsp</title>
<script>
//배열선언
var arr = ['사과', '배', '포도']; //자바스크립트에서 작은 따옴표과 큰 따옴표 구분 안함
//값 변경
arr[0] = '키위';
//생성자 형식으로 배열 선언
var arr2 = new Array('java', 'jsp', 'spring');
document.write(arr2[1]+"<br>"); //두번째 과목 출력
//타입 확인(자바스크립트에서는 배열이라는 타입이 없다.(Object형으로 생성))
//document.write("<br>" + typeof arr);
//document.write("<br>" + typeof arr2);

for(i=0; i<arr2.length; i++){
	document.write(arr2[i] + "<br>");
}
document.write("<hr>");

for(i in arr2){	
	document.write(i + " : ");	
	document.write(arr2[i] + "<br>");	
}

//인덱스 대신에 이름을 가진 배열
var arr3 = []; // = new Array()와 똑같다.()
arr3["취미"] = "게임";
arr3["운동"] = "달리기";
document.write("<br>" + arr3["취미"]);

</script>
</head>
<body>
<h4>자바스크립트 배열과 객체</h4>
</body>
</html>