<%@page import="com.jogiyo.vo.MemberDTO"%>
<%@page import="com.jogiyo.dao.memberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>

<title>회원정보 수정화면</title>
	<style type="text/css">
		table {
			text-align: center;
		}
		.ctd {
			color: white;
			width: 16.66%;
		}
		.wtd {
			width: 25%;
			font-weight: bold;
			text-align: left;
		}
	</style>
<script type="text/javascript">
	// 비밀번호 입력여부 체크
	function checkValue() {
		if (!document.userInfo.password.value) {
			alert("비밀번호를 입력하세요.");
			return false;
		}
	}
</script>

</head>
<body>
<%@include file="../main/header.jsp"%>
	<!-- 회원정보를 가져와 member 변수에 담는다. -->
	<c:set var="member" value="${requestScope.memberInfo}" />
	<!-- 입력한 값을 전송하기 위해 form 태그를 사용한다 -->
	<!-- 값(파라미터) 전송은 POST 방식 -->
	<form method="post" action="MemberModify.do" name="userInfo"
		onsubmit="return checkValue()">
		<div class="table-responsive" style="text-align: center;">
		<br><br>
		<h2>회원정보 수정</h2>
		<br><br><br>
			<!-- 가져온 회원정보를 출력한다. -->
			<table class="table">
				<tr>
					<td class="bg-primary ctd">아이디</td>
					<td class="wtd">${member.id}</td>
				</tr>
				<tr>
					<td class="bg-primary ctd">비밀번호</td>
					<td class="wtd"><input type="password" name="password" class="form-control"
						value="${member.password}"></td>
				</tr>
			</table>
			<br><br>
			<table class="table">
				<tr>
					<td class="bg-primary ctd">이름</td>
					<td class="wtd">${member.user_name}</td>
				</tr>
				<tr>
					<td class="bg-primary ctd">전화번호</td>
					<td class="wtd"><input type="text" name="phone" value="${member.phone}" class="form-control" /></td>
				</tr>
	
				<tr>
					<td class="bg-primary ctd">주소</td>
					<td class="wtd">
					<input type="text" name="address" class="form-control"
								value="${member.address}"/>
					</td>
				</tr>
				<tr>
					<td class="bg-primary ctd">가입일자</td>
					<td class="wtd">${member.r_date}</td>
				</tr>
			</table>
			<br><br> 
			<div class="form-group text-center">
				<button type="button" class="btn btn-warning" style="color: white;" onclick="javascript:window.location='../main/MianForm.do'">취소
				</button> 
				<button type="submit" class="btn btn-primary">수정
				</button>
			</div>
		</div>
	</form>
<%@include file="../main/footer.jsp"%>
</body>
</html>