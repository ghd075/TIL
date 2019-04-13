<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>object.jsp</title>
<script>
//배열[ ], Object { }
var emp = {emp_id : 100, first_name : '홍길동', email : 'ch@na.com'};
document.write(emp.first_name + "<br>");
document.write(emp["email"] + "<br>");

document.write("<hr>");

//List<DTO>
var arrEmp = [
	{emp_id : 100, first_name : '홍길동', email : ['ch@na.com','aa@na.com']},
	{emp_id : 101, first_name : '유관순', email : ['ch1@na.com','aa1@na.com']},
	{emp_id : 102, first_name : '을지문덕', email : 'ch2@na.com'},
]
//첫번째 사원을 이름 출력
document.write(arrEmp[0].first_name + "<hr>");

//두번째 사원의 첫번째 이메일 출력
document.write(arrEmp[1].email[0] + "<hr>");

//모든 사원을 이름만 모두 출력
for(i=0; i<arrEmp.length; i++){
	document.write(arrEmp[i].first_name + "<br>");		
	
}


</script>
</head>
<body>
<h4>자바스크립트 Object</h4>
</body>
</html>