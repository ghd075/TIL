<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertBoard.jsp</title>
</head>
<body>
<h4>게시판등록</h4>
<form action="insertBoardproc.jsp">
	작성자<input name="userName"><br>
	내용<input name="contents"><br>
	<button type="submit">등록</button>
</form>
</body>
</html>