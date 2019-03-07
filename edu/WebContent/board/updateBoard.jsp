<%@page import="com.edu.board.BoardDao"%>
<%@page import="com.edu.board.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateBoard.jsp</title>
</head>
<body>
<h4>게시판수정</h4>
<%
	//단건조회
	String id = request.getParameter("id");
	Board beans = BoardDao.getInstance().select(id);
%>
<form action="updateBoardProc.jsp">
	글번호<input name="id" value="<%=beans.getId() %>"><br>
	작성자<input name="userName" value="<%=beans.getUserName() %>"><br>
	내용<input name="contents" value="<%=beans.getContents() %>"><br>
	<button type="submit">등록</button><br>
	<a href="deleteBoardProc.jsp?id=<%=beans.getId()%>">삭제</a>
</form>
</body>
</html>