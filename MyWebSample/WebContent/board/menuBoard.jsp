<%@page import="com.web.common.Paging"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>CSS Template</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.pagination {
	margin-top: 50px;
	display: inline-block;
	justify-content: center;
}
.pagination ul {
	display: inline-block;
	padding: 10px;
	margin: 0px;
}
.pagination li {
	display: inline-block;
	padding: 10px;
}
.pagination li a{
			text-decoration: none;
			display: block;
			width: 40px;
			height: 40px;
			line-height: 40px;
			background-color: #fff;
			text-align: center;
			text-decoration: none;
			color: #252525;
			border-radius: 4px;
			margin: 5px;
			box-shadow: inset 0 5px 10px rgba(0,0,0,.1), 0 2px 5px;
			}
				
.active{color: red}

.pagination li a:hover {color: #fff; background-color: red;}

*{box-sizing: border-box;}

.menunav {
	 float: left;
	display: inline-block;
	width: 30%;
	height: 100%; 
	background: #199EB8;
	padding: 100px;
}
.ul1 li{height: 50px;}

.ul1 li a{
font-weight: bold;
color: #FFC107;
}

.menunav ul {
	list-style-type: disc;
	padding: 0;
}
.animate {
  margin-top: 20px;
  display: inline-block;
  width: 400px;
  height: 500px;
  border-radius: 10%;
}
.hjh_div {
  width: 70%;
  height: 100%; 
  float: left;
}
.img_span {
 display: inline-block;
  width: 410px;
  height: 550px; 
}
.hjh_body {
font-size: 1.5em;
}
</style>
<script>
//풀다운메뉴 버튼
function changeMenu(){
		location = document.getElementsByName("menu")[0].value
		
}
//페이지변경
function goList(p){
	location = "BoardList.do?p=" + p + "&food_code="+"${param.food_code}";
}
</script>
</head>
<%@include file="../main/header.jsp"%>
<body class="hjh_body">
<div>
<!-- <span> 
	<select name ="menu" onchange="changeMenu()">
	<option value="locationBoard.jsp">지역</option>
	<option value="menuBoard.jsp" selected>메뉴</option>
	<option value="BestList.do" >베스트</option>
	</select>
</span> -->
</div>
		<nav class="menunav">
		<div style="margin-top:30px; color: #FFC107;">
			<ul class = "ul1">
				<li><a href="../board/BoardList.do?food_code=f01">한식</a></li>
				<li><a href="../board/BoardList.do?food_code=f02">중식</a></li>
				<li><a href="../board/BoardList.do?food_code=f03">피자/양식</a></li>
				<li><a href="../board/BoardList.do?food_code=f04">일식/돈까스</a></li>
				<li><a href="../board/BoardList.do?food_code=f05">페스트푸드</a></li>
				<li><a href="../board/BoardList.do?food_code=f06">치킨</a></li>
				<li><a href="../board/BoardList.do?food_code=f07">족발/보쌈</a></li>
				<li><a href="../board/BoardList.do?food_code=f08">분식</a></li>
			</ul>
		</div>	
		</nav>
<!-- 보드게시판 뿌리기 -->
<div class="hjh_div" align="center">
<p align="right" style="margin-top:20px; margin-bottom:0px;"><a href="../board/MemberInsertForm.do"><button type="button">글쓰기</button></a></p>
	<c:forEach items="${list}" var="i">
		<a href="commentPost.jsp?board_no=${ i.getBoard_no()}">
		<span class="img_span">
		♥ ${i.title} ♥<br>
		<img class="animate" src="../images/${i.images}">
		</span>
		</a>
	</c:forEach>
<!-- 페이징버튼 -->
<my:paging paging="${paging}" jsfunc="goList"/>
</div>
</body>
<%@include file="../main/footer.jsp"%>
</html>