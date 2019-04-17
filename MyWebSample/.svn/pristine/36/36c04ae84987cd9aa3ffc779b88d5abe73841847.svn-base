var checkY = 'N';
function checkValue() {
	var form = document.userInfo;
	if (!form.userName.value) {
		alert("이름을 입력하세요.");
		form.userName.value = "";
		form.userName.focus();
		return false;
	}
	if (!form.userID.value) {
		alert("아이디를 입력하세요.");
		form.userID.value = "";
		form.userID.focus();
		return false;
	}
	if (checkY != 'Y') {
		alert("중복체크 해주세요.");
		form.userID.focus();
		return false;
	}
	if (!form.userPassword.value) {
		alert("비밀번호를 입력하세요.");
		form.userPassword.value = "";
		form.userPassword.focus();
		return false;
	}
	// 비밀번호와 비밀번호 확인에 입력된 값이 동일한지 확인
	if (form.userPassword.value != form.userPasswordCheck.value) {
		alert("비밀번호를 동일하게 입력하세요.");
		form.userPasswordCheck.value = "";
		form.userPasswordCheck.focus();
		return false;
	}
	if (!form.userPhone.value) {
		alert("휴대폰번호를 입력하세요.");
		form.userPhone.value = "";
		form.userPhone.focus();
		return false;
	}
	if (!form.userAddress.value) {
		alert("주소를 입력하세요.");
		form.userAddress.value = "";
		form.userAddress.focus();
		return false;
	}
	return true;
}
// 취소 버튼 클릭시 첫화면으로 이동
function goHong() {
	location.href = "../main/main.jsp";
}
// 중복체크(ajax)
function dupChek() {
	var form = document.userInfo;
	// 1. xhr 객체 생성
	var xhttp = new XMLHttpRequest();
	// 2.콜백함수(이벤트 핸들러)
	xhttp.onreadystatechange = function() { // 서버에서 응답이 오면 해당 함수를 실행
		if (this.readyState == 4) { // 4 -> 응답완료
			if (this.status == 200) { // 200 -> 정상실행
				document.getElementById("demo").innerHTML = this.responseText; // dom
				//중복체크여부확인
				if (this.responseText.indexOf('사용가능') >= 0) {
					checkY = 'Y';
				} else {
					checkY = 'N';
				}
			} else {
				document.getElementById("demo").innerHTML = "에러" + this.status;
			}
			// 로딩중 이미지를 제거
		} else {
			// document.getElementById("demo").innerHTML ="처리중"; //로딩중 이미지를 보이게
		}
	};
	var param = "id=" + form.userID.value;
	xhttp.open("POST", "../member/nameDupChek.jsp", true); // 비동기(POST);
	xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhttp.send(param); // 값 전달
}