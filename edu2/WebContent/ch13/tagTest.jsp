<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>tagTest.jsp</title>
</head>
<body>
<my:selectDept/>
<my:selectJotbs/>
<my:time>현재 날짜는</my:time><br>
<my:sum num1="10" num2="20"/>
<my:chart color="red" title="서 적" w="300">
	소 셜<br>
	역 사<br>
	인 문<br>
</my:chart>
<my:chart color="yellow" title="운 동">
	축 구<br>
	배 구<br>
	농 구<br>
</my:chart>
</body>
</html>