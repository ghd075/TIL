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
	<table>
	<tr><th>글번호</th><td><input name="id" value="<%=beans.getId() %>" readonly></td></tr>
	<tr><th>작성자</th><td><input name="userName" value="<%=beans.getUserName() %>"></td></tr>
	<tr><th>내용</th><td><textarea name="contents" rows="3" cols="85"><%=beans.getContents() %></textarea></td></tr>
	</table>
	<button type="submit">등록</button>
	<a href="deleteBoardProc.jsp?id=<%=beans.getId()%>">삭제</a>
</form>
</body>
</html>