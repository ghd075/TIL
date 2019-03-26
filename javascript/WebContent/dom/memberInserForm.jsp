<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>폼필드 속성(체크,select..)</title>
<script>

</script>
<script>
//validation(유효성) : 입력값 검증
function check(){
	//이름 체크
	//var username = document.frm.username.value;
	//var username = document.forms["frm"]["username"].value; //name속성으로 찾아가는 방법
	//var username = document.getElementsByName("username")[0].value;
	//id로 찾아가는 방법
	var username = document.getElementById("username").value;
	if(username == ""){
		alert("이름을 입력하시오.");
		document.frm.username.focus();
		return false;
	}
	//패스워드 체크
	var userpass = document.frm.userpass.value;
	if(userpass == ""){
		alert("패스워드를 입력하시오.");
		document.frm.userpass.focus();
		return false;
	}
	//취미 체크
	var chk = document.getElementsByName("hobby");
	var cnt = 0;
	for(i=0; i<chk.length;i++){
		//체크된 갯수 카운터
		if(chk[i].checked == true){
			cnt++;
		}
	}
	if(cnt == 0){
		alert("취미를 선택하시오.");
		return false;
	}
	//성별 체크
	var chk = document.getElementsByName("sex");
	var cnt = 0;
	for(i=0; i<chk.length;i++){
		//체크된 갯수 카운터
		if(chk[i].checked == true){
			cnt++;
		}
	}
	if(cnt == 0){
		alert("성별을 선택하시오.");
		return false;
	}
	//직업 체크
	if(frm.job.selectedIndex < 1){
		alert("직업을 선택하시오.");
		return false;
	}
	return true; //폼을 전송
}
//중복체크(ajax)
function dupChek(){
	//1. xhr 객체 생성
	var xhttp = new XMLHttpRequest();
	//2.콜백함수(이벤트 핸들러)
	xhttp.onreadystatechange = function() { //서버에서 응답이 오면 해당 함수를 실행
		if (this.readyState == 4) { //4 -> 응답완료
			if(this.status == 200){ //200 -> 정상실행
				document.getElementById("demo").innerHTML = this.responseText; //dom
				} else {
					document.getElementById("demo").innerHTML = "에러" + this.status;
				}
				//로딩중 이미지를 제거
			}else{
				//document.getElementById("demo").innerHTML ="처리중"; //로딩중 이미지를 보이게
			}
		};
	var param = "name=" + frm.username.value;
    //xhttp.open("GET", "../server/nameDupChek.jsp"+param, true); //비동기(get)
    xhttp.open("POST", "../server/nameDupChek.jsp", true); //비동기(POST);
    xhttp.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
    //xhttp.open("GET", "../server/nameDupChek.jsp"+param, false); //false는 동기식 처리
    xhttp.send(); //동기식(false) 키보드입력처럼 블록킹 함수로 처리 완료되어야 다음 라인 실행
    xhttp.send(param); //값 전달
    //console.log("동기식 전송 테스트");
}
</script>
</head>
<body>
<!-- memberInserForm.jsp -->
<form name="frm" onsubmit="return check()">
	이름 :
		<input type="text" name="username" id="username" onkeyup="dupChek()"/>
		<span id="demo"></span><br>
	패스워드 :
		<input type="password" name="userpass"/><br>
	관심항목:
		<input type="checkbox" name="hobby" value="jsp"> JSP
		<input type="checkbox" name="hobby" value="java"> JAVA
		<input type="checkbox" name="hobby" value="jquery"> JQUERY <br/>	
	성별:
		<input type="radio" name="sex" value="M"> 남자	
		<input type="radio" name="sex" value="F"> 여자   <br/>
	결혼여부:
		<input type="radio" name="wed" value="1" checked="checked"> 미혼	
		<input type="radio" name="wed" value="2"> 기혼   <br/>
	직업 :
		<select name="job">
			<option>직업선택
			<option>프로그래머
			<option>디자이너
			<option>웹퍼블리셔
		</select><br>
		<input type="submit" value="등록">
		<input type="reset" value="초기화">
</form>
</body>
</html>