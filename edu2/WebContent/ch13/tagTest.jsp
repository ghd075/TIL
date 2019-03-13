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
</body>
</html>