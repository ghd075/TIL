<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 부트스트랩 CSS 추가하기 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!-- 커스텀 CSS 추가하기 -->
<link rel="stylesheet" href="../css/custom.css">
<link rel="stylesheet" type="text/css" href="../css/util.css">
<!-- 커스텀 자바스크립트 추가 -->
<script type="text/javascript" src="../js/main.js" charset="utf-8"></script>
<!-- nevigator 영역 -->
<nav class="navbar navbar-expand-sm navbar-dark" style="background-color: #199EB8">
	<div id="logo" class="pull-left">
		<a class="navbar-brand" href="../index.jsp"><img src="../images/logo.png" alt="" title="" /></img></a>
	</div>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    	<span class="navbar-toggler-icon"></span>
  	</button>
	<div class="collapse navbar-collapse" id="collapsibleNavbar" style="font-weight: bold;">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" onclick="changeView(0)" href="#" style="color: #ffc107;">HOME</a></li>
			<!-- 로그인 안 되었을 경우 - 로그인, 회원가입 버튼을 보여준다.  -->
			<c:if test="${sessionScope.sessionID==null}">
				<li class="nav-item"><a class="nav-link" onclick="changeView(1)" href="#" style="color: #ffc107;">로그인</a></li>
				<li class="nav-item"><a class="nav-link" onclick="changeView(3)" href="#" style="color: #ffc107;">회원가입</a></li>
			</c:if>
			<!-- 유저 로그인시 음식게시판, 지역게시판, 베스트게시판 버튼을 보여준다. -->
			<c:if test="${sessionScope.sessionID != null && sessionScope.sessionID != 'admin'}">
				<li class="nav-item"><a class="nav-link" onclick="changeView(6)" href="#" style="color: #ffc107;">음식게시판</a></li>
				<li class="nav-item"><a class="nav-link" onclick="changeView(7)" href="#" style="color: #ffc107;">지역게시판</a></li>
				<li class="nav-item"><a class="nav-link" onclick="changeView(8)" href="#" style="color: #ffc107;">베스트게시판</a></li>
				<li class="nav-item"><a class="nav-link" onclick="changeView(11)" href="#" style="color: #ffc107;">통계현황</a></li>
			</c:if>
			<!--  관리자 로그인 -->
			<c:if test="${sessionScope.sessionID !=null && sessionScope.sessionID=='admin'}">
				<li class="nav-item"><a class="nav-link" onclick="changeView(12)" href="#" style="color: #ffc107;">공지사항</a></li>
				<li class="nav-item"><a class="nav-link" onclick="changeView(5)" href="#" style="color: #ffc107;">게시글관리</a></li>
				<li class="nav-item"><a class="nav-link" onclick="changeView(9)" href="#" style="color: #ffc107;">회원관리</a></li>
				<li class="nav-item"><a class="nav-link" onclick="changeView(10)" href="#" style="color: #ffc107;">블랙리스트회원관리</a></li>
			</c:if>
			<!-- 로그인 되었을 경우 - 내 정보보기 버튼 ,로그아웃 버튼을 보여준다. -->
			<c:if test="${sessionScope.sessionID!=null}">
				<li class="nav-item"><a class="nav-link" onclick="changeView(4)" href="#" style="color: #ffc107;">내정보보기</a></li>
				<li class="nav-item"><a class="nav-link" onclick="changeView(2)" href="#" style="color: #ffc107;">로그아웃</a></li>
			</c:if>
		</ul>
	</div>
</nav>  	

<!-- <div class="jumbotron text-center m-b-0">
	<h1>조기요</h1>
</div> -->
<div class="container-fluid text-center m-t-30 m-b-20">
	<div class="row content">
		<div class="col-sm-2 sidenav">
		</div>
		<div class="col-sm-8 text-left" style="height:100%;">