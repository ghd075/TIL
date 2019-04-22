<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board.jsp</title>
</head>
<body>
<h3>게시판</h3>
<%-- 로그인 성공 --%>
<c:if test="${not empty sessionScope.userName}">
	${userName} 님 환영합니다.
	<input type="button" onclick="location='logout'" value="로그아웃">
</c:if>
<%-- 로그인 실패 --%>
<c:if test="${empty sessionScope.userName}">
	<a href="login">로그인</a>
</c:if>

<%-- ${list} --%>
<%-- 검색조건 : ${boardVO} --%>
<form name="searchFrm">
	<!-- input태그에 키워드를 넣고 검색하면 값이 그대로 보이는 기능 -->
	<select name="searchCondition">
		<option value="">선택</option>
		<!-- 방법1 JSTL(if태그)사용 -->
		<option value="TITLE"
		<%-- <c:if test="${boardVO.searchCondition=='CONTENT'}">selected</c:if> --%>
		>제목</option>
		<option value="CONTENT"
		<%-- <c:if test="${boardVO.searchCondition=='CONTENT'}">selected</c:if> --%>
		>내용</option>
	</select>
	<!-- 방법2 자바스크립트사용 -->
	<script>
		searchFrm.searchCondition.value='${boardVO.searchCondition}';
	</script>
	<input name="searchKeyword" value="${boardVO.searchKeyword}"/>
	<button>검색</button>
</form>
<form action="deleteBoard">
	<table border="1">
	<tr><th>번호</th><th>작성자</th><th>제목</th><th>내용</th><th>작성일자</th><th>조회수</th><th>삭제</th></tr>
	<c:forEach items="${list}" var="board">
		<tr>
			<td>${board.seq}</a></td>
			<td>${board.writer}</td>
			<td><a href="boardUpdate?seq=${board.seq}">${board.title}</td>
			<td>${board.content}</td>
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