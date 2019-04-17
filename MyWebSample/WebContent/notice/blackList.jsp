<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>블랙 리스트 관리</title>
</head>
<body>
<%@include file="../main/header.jsp"%>
	<h3>블랙리스트 관리</h3><br>
	<button type="button" class="btn btn-outline-primary"onclick="location='AddBlackList.jsp'">
	블랙리스트 추가</button><br><br>
	<button type="button" class="btn btn-outline-primary" onclick="location='DeleteBlackList.jsp'">
	블랙리스트 삭제</button><br><br>
</body>
<%@include file="../main/footer.jsp"%>
</html>