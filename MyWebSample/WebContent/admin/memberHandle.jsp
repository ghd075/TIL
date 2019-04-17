<%@page import="com.web.common.Paging"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="my" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">

.pagination {
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

.active {
	color: red;
}

a {
	text-decoration: none;
}

* {
	box-sizing: border-box;
}
td {
	border-bottom: 1px solid;
}
</style>

<!-- 전체선택을 하기 위해서는 자바스크립트는 포문을 써야하지만 jquery를 쓰면 배열을 자동으로 받아온다 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
//풀다운메뉴 버튼
function changeMenu_h(){
		form2.a.value = document.getElementsByName("menu")[0].value
		form2.p.value = 1;
		form2.submit();
}

//페이징 기능
function goList(p){
	form2.p.value = p;
	form2.submit();
	
}

//삭제 기능//체크박스 입력 체크
function MemberDelete(){
	var chk = document.getElementsByName("user_code_d");//값들을 받아온.
	var cnt = 0; //카운터 초기값은 0
//board_no_d그룹에서 체크된 값을 찾기위해 for문을 돌려 체크된 값이 있는지를 확인한다.	
	for (i = 0; i < chk.length; i++) { 
		//체크된 카운트
		if (chk[i].checked == true) { //태그에 체크가 되었는지 확인
			cnt++ //체크수 증가
		}
	}
//체크수가 0이면 경고창이뜨고 아니면은 밖으로 나간다.
	if (cnt == 0) { 
		alert("삭제할 회원을 선택하세요");
		return false;
	}
//체크가 되어있다면,
	if(confirm("삭제할까요?")){
		form.submit();
	}
}
//풀다운메뉴 초기값 설정
window.onload=function(){//바디실행후 작동
	
	if('${param.a}'=='asc'){
		document.getElementsByName("menu")[0].selectedIndex=1;
	}
}
//체크박스 전체선택, 전체해제
function checkAll(){
      if( $("#th_checkAll").is(':checked') ){
        $("input[name=user_code_d]").prop("checked", true);
      }else{
        $("input[name=user_code_d]").prop("checked", false);
      }
}
</script>
</head>

<body>
<%@include file="../main/header.jsp"%>
<article class="hjh_aticle5">

<h2 align="center">회원관리</h2>
	
<form action = "MemberList.do" name="form2">
	<input type="hidden" name="p" value="${param.p}"></input>
	<input type="hidden" name="a" value="${param.a}"></input>
</form>


<form action="MemberDelete.do" name="form">
<span>
<select name = "menu" onchange="changeMenu_h()">
	<option value="desc">가입날짜 (최근순)</option>
	<option value="asc">가입날짜(오래된순)</option>
</select>
</span>
<span style="float: right;">
	<button class="btn btn-info" type="button" onclick="MemberDelete()">삭제</button>
</span>
	
<div align="center" style="margin-top: 10px;">
<table width="100%" style=>
		<tr bgcolor="gray" align= "center" >
			<td>
<label for="th_checkAll"><input type="checkbox" id="th_checkAll" onclick="checkAll();"/>번호</label>
			</td>
			<td bgcolor="gray">유저ID</td>
			<td bgcolor="gray">사용자이름</td>
			<td bgcolor="gray">전화번호</td>
			<td bgcolor="gray">주소</td>
			<td bgcolor="gray">가입날짜</td>
		</tr>
	
		<c:forEach items="${list}" var="i">
			<tr align = "center">
				<td><label for="${i.getRn()}"><input type="checkbox" name="user_code_d" id="${i.getRn()}" value="${ i.getUser_code()}">${i.getRn()}</label></td>
				<td>${i.getUser_code()}</td>
				<td>${i.getUser_name()}</td>
				<td>${i.getPhone()}</td>
				<td>${i.getAddress()}</td>
				<td>${i.getR_date()}</td>
			</tr>
		</c:forEach>
</table>
<!-- 페이징버튼 -->
<my:paging paging="${paging}" jsfunc="goList"/>
</div>
</form>

</article>

<%@include file="../main/footer.jsp"%>
</body>
</html>