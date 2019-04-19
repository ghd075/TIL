<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>게시판</h3>
<%-- ${list} --%>
<form>
	<select name="searchCondition">
		<option value="">선택</option>
		<option value="TITLE">제목</option>
		<option value="CONTENT">내용</option>
	</select>
	<input name="searchKeyword"/>
	<button>검색</button>
</form>
<form action="deleteBoard">
	<table border="1">
	<tr><th>번호</th><th>작성자</th><th>제목</th><th>작성일자</th><th>조회수</th><th>삭제</th></tr>
	<c:forEach items="${list}" var="board">
		<tr>
			<td>${board.seq}</td>
			<td>${board.writer}</td>
			<td>${board.title}</td>
			<td>${board.regDate}</td>
			<td>${board.cnt}</td>
			<td><input type="checkbox" name="seqs" value="${board.seq}"></td>
		</tr>
	</c:forEach>
	</table>
	<button>선택삭제</button>
</form>
</body>
</html>