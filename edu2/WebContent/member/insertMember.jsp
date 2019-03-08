<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertMember.jsp</title>
</head>
<body>
<%@include file="../main/header.jsp"%>
<h4>회원등록</h4>
<form action="<%=request.getContextPath()%>/insertMember">
	아이디 : <input name="userid"><br>
	비밀번호 : <input name="userpw"/><br>
	이름 : <input name="username"/><br>
	직업 : <input name="job"/><br>
	취미 : <input name="hobby"/><br>
	자기 소개 : <input name="info"/><br>
	성별 : <input name="gender"/><br>
	가입일자 : <input type="date" name="regdate" /><br>
	<button type="submit">등록</button>
</form>
<%@include file="../main/footer.jsp"%>
</body>
</html>