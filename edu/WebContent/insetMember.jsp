<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	font-size: 12px;
	font-family: "돋음";
	font-weight: bold;
	color: #242424;
}

table {
	border-collapse: collapse;
	width: 100%;
}

td {
	padding: 10px;
	border-width: thick;
}

select {
	height: 22px;
}

label {
	margin-left: -1px;
}

.box {
	margin: 0 auto; 
	width:1000px;
}
</style>
</head>
<body>
	<form action="">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="userId"></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="password" name="userPw1"></td>
			</tr>
			<tr>
				<td>PW확인</td>
				<td><input type="password" name="userPw2"></td>
			</tr>
			<tr>
				<td>직업</td>
				<td><span style="display: inline-block;"> 
				<select name="job" style="width: 60px">
							<option>선택</option>
							<option value="01">응용프로그래머</option>
							<option value="02">디자이너</option>
							<option value="03">웹프로그래머</option>
				</select></td>
			</tr>
			<tr>
				<td>성별<font color="red">*</font></td>
				<td><span style="display: inline-block;"> <input
						type="radio" name="gender" value="1" id="man" /><label for="man">남</label>
						<input type="radio" name="gender" value="2" id="woman" /><label
						for="woman">여</label>
				</span></td>
			</tr>
			<tr>
				<td>자기소개</td>
				<td><textarea name="leave_text" rows="3" cols="85"></textarea>
				</td>
			</tr>
			<tr>
				<td>취미</td>
				<td><input type="checkbox" name="hobby1" value="book">
					독서 <input type="checkbox" name="hobby2" value="came"> 게임</td>
			</tr>
		</table>
		<div class="box">
			<input type="submit" value="전송"> 
			<input type="reset" value="취소">
		</div>
	</form>
</body>
</html>