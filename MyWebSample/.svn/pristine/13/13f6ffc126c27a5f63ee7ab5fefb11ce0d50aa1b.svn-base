<%@page import="com.jogiyo.vo.MemberDTO"%>
<%@page import="com.jogiyo.dao.memberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%
	// MemberInfoAction에서 넘긴 회원정보를 추출한다.
	//MemberBean member=(MemberBean)request.getAttribute("memberInfo");
%>

<html>
<head>
<title>현재 유저정보 출력화면</title>
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
		}
	</style>
<!-- 회원가입 관련 자바스크립트 -->
<script src="../js/member.js"></script>
</head>
<body>
<%@include file="../main/header.jsp"%>
		<!-- 회원정보를 가져와 member 변수에 담는다. -->
		<!-- 요청한 memberDTO에 값을 넣는다. -->
		<c:set var="member" value="${requestScope.memberInfo}"/>
		<!-- 가져온 회원정보를 출력한다. -->
		<div class="table-responsive" style="text-align: center;">
			<br><br>
			<h2>내정보보기</h2>
			<br><br>
			<table class="table">
				<tr>
					<td class="bg-primary ctd">아이디</td>
					<td class="wtd">${member.id}</td>
				</tr>			
				<tr>
					<td class="bg-primary ctd">비밀번호</td>
					<td class="wtd">${member.password}</td>
				</tr>
						
				<tr>
					<td class="bg-primary ctd">이름</td>
					<td class="wtd">${member.user_name}</td>
				</tr>
						
				<tr>
					<td class="bg-primary ctd">전화번호</td>
					<td class="wtd">${member.phone}</td>
				</tr>
				<tr>
					<td class="bg-primary ctd">주소</td>
					<td class="wtd">
						${member.address} 
					</td>
				</tr>
				<tr>
					<td class="bg-primary ctd">가입일자</td>
					<td class="wtd">
						${member.r_date}
					</td>
				</tr>
			</table>
			<br><br>
			<div style="margin:0 auto">
				<button class="btn btn-primary" type="button" onclick="changeForm(-1)">뒤로</button>
				<button class="btn btn-primary" type="button" onclick="changeForm(0)">회원정보 변경</button>
				<button class="btn btn-primary" type="button" onclick="changeForm(1)">회원탈퇴</button>
			</div>
		</div>
		<br><br><br><br><br>
<%@include file="../main/footer.jsp"%>
</body>
</html>