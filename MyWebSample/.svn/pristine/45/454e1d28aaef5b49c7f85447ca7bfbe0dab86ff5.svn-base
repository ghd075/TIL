<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<!-- 로그인 템플릿 css 추가-->
<link rel="icon" type="image/png" href="../images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="../vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="../vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="../css/util.css">
<link rel="stylesheet" type="text/css" href="../css/main.css">
<!--===============================================================================================-->
<!-- 회원가입 관련 자바스크립트 -->
<script src="../js/register.js"></script>
</head>
<body>
<%@include file="../main/header.jsp"%>
	<div class="limiter">
		<div class="container-login100"
			style="background-image: url('../images/bg-01.jpg');">
			<div class="wrap-login100 p-t-30 p-b-50">
				<span class="login100-form-title p-b-41"> 회원가입 </span>
				<form class="login100-form validate-form p-b-50 p-t-5" action="MemberInsert.do" name="userInfo" onsubmit="return checkValue()" method="post">
					<div class="container">
						<div class="form-group">
	                        <label for="userName">성명</label>
	                        <input type="text" class="form-control" id="userName" name="userName" placeholder="이름을 입력해 주세요" maxlength="8">
	                    </div>
	                    <div class="form-group">
	                        <label for="userID">ID</label>
	                        <input type="text" class="form-control m-b-10" id="userID" name="userID" placeholder="아이디를 입력해주세요" onkeyup="dupChek()">
	                        <span id="demo" style="color: red;"></span>
	                    </div>
	                    <div class="form-group">
	                        <label for="userPassword">비밀번호</label>
	                        <input type="password" class="form-control" id="userPassword" name="userPassword" placeholder="비밀번호를 입력해주세요">
	                    </div>
	                    <div class="form-group">
	                        <label for="userPasswordCheck">비밀번호 확인</label>
	                        <input type="password" class="form-control" id="userPasswordCheck" name="userPasswordCheck" placeholder="비밀번호 확인을 위해 다시 한번 입력 해 주세요">
	                    </div>
	                    <div class="form-group">
	                        <label for="userPhone">휴대폰 번호</label>
	                        <input type="tel" class="form-control" id="userPhone" name="userPhone" placeholder="휴대폰번호를 입력해 주세요">
	                    </div>
	                    <div class="form-group">
	                        <label for="userAddress">주소</label>
	                        <input type="tel" class="form-control" id="userAddress" name="userAddress" placeholder="주소를 입력해 주세요">
	                    </div>
					</div>
					<div class="container-login100-form-btn m-t-32">
						<button id="join-submit" class="login100-form-btn m-r-5">회원가입
							<i class="fa fa-check spaceLeft"></i>
						</button>
						<button type="button" class="login100-form-btn" onclick="goHong()">가입취소
							<i class="fa fa-times spaceLeft"></i>
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- 로그인 템플릿 js추가 -->
	<script src="../vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="../vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="../vendor/bootstrap/js/popper.js"></script>
	<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="../vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="../vendor/daterangepicker/moment.min.js"></script>
	<script src="../vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script src="../vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
	<script src="../js/main.js"></script>
<%@include file="../main/footer.jsp"%>
</body>
</html>