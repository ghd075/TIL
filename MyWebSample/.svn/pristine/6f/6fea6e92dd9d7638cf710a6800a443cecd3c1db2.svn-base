<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jogiyo.vo.BlackDto"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>블랙리스트 추가</title>
</head>
<body>
<%@include file="../main/header.jsp"%>
<form action="AddBlack.do" method="post">
	<h3>등록된 아이디는 사이트 이용이 불가능합니다.</h3>
	userid : <input type="text" id="userid" name="userid" value="${black.userid}" 
	style="width:150 height:21; background-color:ivory; border:1 solid blue; 
	font-family:굴림; font-size:10pt; color:red" onMouseOver="this.style.backgroundColor='yellow'" 
	onMouseOut="this.style.backgroundColor='ivory'">
	<input type="submit" class="btn btn-info" value="추가">
</form>
</body>
<%@include file="../main/footer.jsp"%>
</html>