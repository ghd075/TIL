<%@page import="com.jogiyo.vo.NoticeDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>공지사항 삽입 페이지</title>
</head>
<body>
<%@include file="../main/header.jsp"%>
${error}
<form action="AddNotice.do" method="post">
	<h3>삽입</h3>
	notice_no : <input type="text" id="notice_no" name="notice_no" readonly  value="${notice.notice_no}" 
	style="width:150 height:21; background-color:ivory; border:1 solid blue; 
	font-family:굴림; font-size:10pt; color:red" onMouseOver="this.style.backgroundColor='yellow'" 
	onMouseOut="this.style.backgroundColor='ivory'"><br><br>
	
	notice_title : <input type="text" id="notice_title" name="notice_title"   value="${notice.notice_title}" 
	style="width:150 height:21; background-color:ivory; border:1 solid blue; 
	font-family:굴림; font-size:10pt; color:red" onMouseOver="this.style.backgroundColor='yellow'" 
	onMouseOut="this.style.backgroundColor='ivory'"> <br><br>
	
	notice_contents : <textarea id="notice_contents" name="notice_contents" 
	style="width:150 height:21; background-color:ivory; border:1 solid blue; 
	font-family:굴림; font-size:10pt; color:red" onMouseOver="this.style.backgroundColor='yellow'" 
	onMouseOut="this.style.backgroundColor='ivory'">${notice.notice_contents}</textarea><br> 
	<input type="submit" class="btn btn-info" value="삽입">
	</form>
</body>
<%@include file="../main/footer.jsp"%>
</html>