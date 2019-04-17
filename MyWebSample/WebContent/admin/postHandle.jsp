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
	justify-content: center; /* 페이징중앙정렬 */
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
	color: red
}

a {
	text-decoration: none
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
		form2.submit();
}

//페이징 기능
function goList(p){
	form2.p.value = p;
	form2.submit();
	
}

//삭제 기능
function PostDelete(){
	//체크박스 입력 체크
	var chk = document.getElementsByName("board_no_d"); //태그찾기
	var cnt = 0; //태그의 배열
	for (i = 0; i < chk.length; i++) { //board_no_d그룹에서 체크된 값을 찾기위해 for문을 돌려 체크된 값이 있는지를 확인한다.
		//체크된 카운트
		if (chk[i].checked == true) { //태그에 체크가 되었는지 확인
			cnt++ //체크수 증가
		}
	}
	if (cnt == 0) { // 체크수가 0이면
		alert("삭제할 게시글을 선택하세요");
		return false;

	}
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
        $("input[name=board_no_d]").prop("checked", true);
      }else{
        $("input[name=board_no_d]").prop("checked", false);
      }
}
</script>
</head>

<body>
<%@include file="../main/header.jsp"%>
<article class="hjh_aticle6">

<h2 align="center">게시글관리</h2>
<!-- 페이징 값 보내는 폼(form2) -->
<form action = "PostList.do" name="form2">
	<input type="hidden" name="p" value="${param.p}"></input>
	<input type="hidden" name="a" value="${param.a}"></input>
</form>
<!-- 삭제 값 보내는 폼(form) -->
<form action="PostDelete.do" name="form">
<span>
<select name = "menu" onchange="changeMenu_h()">
	<option value="desc">조회건수 (오름)</option>
	<option value="asc" >조회건수(내림)</option>
</select>
</span>
<span style="float: right;">
	<button class="btn btn-info" type="button" onclick="PostDelete()">삭제</button>
</span>
<div align="center" style="margin-top: 10px;">
<table width="100%">
		<tr bgcolor="gray" align= "center" >
			<td bgcolor="gray">
<label for="th_checkAll"><input type="checkbox" id="th_checkAll" onclick="checkAll();"/>번호</label>
			</td>
			<td bgcolor="gray">게시글번호</td>
			<td bgcolor="gray">제목</td>
			<td bgcolor="gray">작성자</td>
			<td bgcolor="gray">조회수</td>
		</tr>
	
		<c:forEach items="${list}" var="i">
			<tr align = "center">
				<td><label for="${i.getRn()}"><input type="checkbox" name="board_no_d" id="${i.getRn()}" value="${ i.getBoard_no()}">${i.getRn()}</label></td>
				<td><a href="../board/commentPost.jsp?board_no=${ i.getBoard_no()}">
					${i.getBoard_no() }</a></td>
				<td>${i.getTitle()}</td>
				<td>${i.getUser_code() }</td>
				<td>${i.getCnt() }</td>
			</tr>
		</c:forEach>
</table>
</div>
</form>
</article>
<!-- 페이징버튼 -->
<my:paging paging="${paging}" jsfunc="goList"/>
<%@include file="../main/footer.jsp"%>
</body>
</html>