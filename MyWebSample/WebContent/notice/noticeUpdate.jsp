<%@page import="com.jogiyo.vo.NoticeDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>	
</head>
<body>
<%@include file="../main/header.jsp"%>
<h3>수정페이지</h3>

<form action="NoticeUpdate.do" method="post">
   notice_no : <input type="text" id="notice_no" name="notice_no"  value="${notice.notice_no}"  > <br><br>
   notice_title : <input type="text" id="notice_title" name="notice_title"   value="${notice.notice_title}"  > <br><br>
   notice_contents : <input type="text" id="notice_contents" name="notice_contents"  value="${notice.notice_contents}"  > 
  <input type="submit" class="btn btn-info"  value="수정" />
  
</form>
</body>
<%@include file="../main/footer.jsp"%>
</html>