<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardInsert.jsp</title>
</head>
<body>
<h3>게시글 등록</h3>
<form action="boardInsert">
	작성자<input name="writer"><br>
	제목<input name="title"><br>
	내용<textarea rows="3" cols="20" name="content"></textarea>
	<button>등록</button>
</form>
</body>
</html>