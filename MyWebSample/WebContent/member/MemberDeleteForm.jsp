<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>탈퇴 화면</title>
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
	<script type="text/javascript">
		// 비밀번호 미입력시 경고창
		function checkValue(){
			if(!document.deleteform.password.value){
				alert("비밀번호를 입력하지 않았습니다.");
				return false;
			}
		}
	</script>
</head>
<body>
<%@include file="../main/header.jsp"%>
		<form name="deleteform" method="post" action="MemberDelete.do"
			onsubmit="return checkValue()">
			<div class="table-responsive" style="text-align: center;">
				<br><br>
				<h2>회원 탈퇴</h2>
				<br><br><br>
				<table class="table">
					<tr>
						<td class="bg-primary ctd">비밀번호</td>
						<td class="wtd"><input type="password" name="password" class="form-control"></td>
					</tr>
				</table>	
				<br><br>
				<div class="form-group text-center"> 
					<button type="button" class="btn btn-warning" style="color: white;" onclick="javascript:window.location='../main/MianForm.do'">취소
					</button>
					<button type="submit" class="btn btn-primary" >삭제</button>
				</div> 
			</div>
		</form>
		<br><br><br><br><br><br><br><br><br><br><br>
<%@include file="../main/footer.jsp"%>
</body>
</html>