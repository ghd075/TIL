<%@page import="com.jogiyo.vo.NoticeDto"%>
<%@page import="com.web.common.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>공지사항 삽입 페이지</title>
</head>
<body>
<%@include file="../main/header.jsp"%>

<form action="NoticeDelete.do" method="post">
	<h3>정보 삭제</h3>
	notice_no : <input type="text" id="notice_no" name="notice_no"  value="${notice.notice_no}" 
	style="width:150 height:21; background-color:ivory; border:1 solid blue; 
	font-family:굴림; font-size:10pt; color:red" onMouseOver="this.style.backgroundColor='yellow'" 
	onMouseOut="this.style.backgroundColor='ivory'">
	<input type="submit" class="btn btn-info" value="삭제">
	</form>
</body>
<%@include file="../main/footer.jsp"%>
</html>