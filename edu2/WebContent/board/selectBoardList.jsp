<%@page import="com.edu.board.BoardDao"%>
<%@page import="com.edu.board.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectDeptList.jsp</title>
</head>
<body>
<%@include file="../main/header.jsp"%>
<h4>게시판목록</h4>
<a href="insertBoard.jsp">게시판등록</a>
<table>
	<tr><td>글번호</td><td>작성자</td><td>내용</td></tr>
<%
	ArrayList<Board> list = BoardDao.getInstance().selectAll();
	for(int i = 0; i<list.size(); i++){
		Board beans = list.get(i);
%>
	<tr>
		<td>
		<a href="updateBoard.jsp?id=<%=beans.getId()%>"><%=beans.getId()%>
		</a></td>
		<td><%=beans.getUserName() %></td>
		<td><%=beans.getContents() %></td>
	</tr>
<%} %>
</table>
<%@include file="../main/footer.jsp"%>
</body>
</html>