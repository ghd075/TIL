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
<form action="insertBoardServ">
	<table>
	<tr><th>작성자</th><td><input name="userName"></td></tr>
	<tr><th>내용</th><td><textarea name="contents" rows="3" cols="85"></textarea></td></tr>
	</table>
	<button type="submit">등록</button>
</form>
</body>
</html>