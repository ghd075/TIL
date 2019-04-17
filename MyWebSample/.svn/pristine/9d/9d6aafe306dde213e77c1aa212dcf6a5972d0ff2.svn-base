<%@page import="com.web.common.Paging"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>CSS Template</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>

.pagination li{display: inline-block; padding: 10px;}
.active{color: red}
a{text-decoration: none}

* {
	box-sizing: border-box;
}

.animate {
  width: 450px;
  height: 300px;
  border-radius: 10%;
}

.hjh_body {
font-size: 1.5em;
}
</style>
<script type="text/javascript">

function changeMenu(){
		location = document.getElementsByName("menu")[0].value
}
</script>
</head>
<%@include file="../main/header.jsp"%>
<body class="hjh_body">	
<!-- <div>
	<select name = "menu" onchange="changeMenu()">
	<option value="locationBoard.jsp" >지역</option>
	<option value="menuBoard.jsp" >메뉴</option>
	<option value="BestList.do" selected>베스트</option>
	</select>
</div>-->
<div align="center">
<!-- varStatus로 배열의 순서정함 -->
	<c:forEach items="${list}" var="i" varStatus="s">
	<p style="color:RED">${s.count}위 <a href="commentPost.jsp?board_no=${ i.getBoard_no()}">♥ ${i.title} ♥</p>
	<img align ="top" class="animate" src="../images/${i.images}"></a><br>
	</c:forEach>
</div>
</body>
<%@include file="../main/footer.jsp"%>
</html>