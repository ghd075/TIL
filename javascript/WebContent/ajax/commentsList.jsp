<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>댓글</title>
<style>
	.comment { border : 1px dotted blue; }
</style>
<script src="../js/ajax.js"></script>
<script>
window.onload = function() {
	loadCommentList();  // 목록조회 ajax 요청
}
//목록조회 요청
function loadCommentList() {
	var param = "cmd=selectAll";
	new ajax.xhr.Request("CommentsJsonServ", param, loadCommentResult, 'GET');
}
//목록조회 콜백함수
function loadCommentResult(req) {
	if (req.readyState == 4) {    //응답이 완료
		if (req.status == 200) {  //정상실행  
/* 			var xmlDoc = req.responseXML;   // 응답결과가 XML 
			var code = xmlDoc.getElementsByTagName('code').item(0)
			                 .firstChild.nodeValue;
			if (code == 'success') {
				// data 태그의 태그바디값(string)을  json 객체로 변환 
				var commentList = eval( "(" +
						 xmlDoc.getElementsByTagName('data').item(0)
							   .firstChild.nodeValue +
									    ")" ); */
				// 응답결과를 JSON 객체로 전환
				var commentList = JSON.parse(req.responseText);
				var listDiv = document.getElementById('commentList');
				for (var i = 0 ; i < commentList.length ; i++) {
					var commentDiv = makeCommentView(commentList[i]);//댓글div 태그생성
					listDiv.appendChild(commentDiv);  // div목록에 댓글div 추가
				}
/* 			} else if (code == 'error') {
				var message = xmlDoc.getElementsByTagName('data')
				                    .item(0).firstChild.nodeValue;
				alert("에러 발생:"+message);*/
		} else {  	alert("댓글 목록 로딩 실패:"+req.status);}  //에러인 경우 상태코드 출력
	}
}

function makeCommentView(comment){
	var div = document.createElement("div");  //div태그 생성 <div></div>
	div.setAttribute("id", "c"+comment.id); //div태그에 id값 부여 <div id ="c2">
	div.className = 'comment'; //div태그에 class속성을 comment로 추가 <div id="c2" class="comment">
	div.comment = comment;  //{id:1,.... } //<div id="c2" class="comment" comment="{댓글한번}">
	
	var str = "<strong>" + comment.name + "</strong>" + comment.content
+"<input type=\"button\" value=\"수정\" onclick=\"viewUpdateForm('"+comment.id+"')\"/>"
+"<input type=\"button\" value=\"삭제\" onclick=\"confirmDeletion('"+comment.id+"')\"/>"
	div.innerHTML = str;
	return div;
}

//댓글 등록 ajax 요청
function addComment() {
	//각각 name값 받아오기
	var name = document.addForm.name.value;
	var content = document.addForm.content.value;
	var params = "name="+encodeURIComponent(name)+"&"+
	             "content="+encodeURIComponent(content) + "&cmd=insert";
	new ajax.xhr.Request('CommentsJsonServ', params, addResult, 'POST');
}
////댓글 등록 콜백함수
function addResult(req) {
	if (req.readyState == 4) {
		if (req.status == 200) {
/* 			var xmlDoc = req.responseXML;
			var code = xmlDoc.getElementsByTagName('code').item(0)
			                 .firstChild.nodeValue;
			if (code == 'success') { */
/* 				var comment = eval( "(" +
				    xmlDoc.getElementsByTagName('data').item(0)
				          .firstChild.nodeValue +
				                     ")" ); */
				var comment = eval( "(" + req.responseText + ")" ); //JSON.parse() //eval("5+704")
				//받아온 문자값을 자바스크립트 코드로 변환해주는 함수
				var listDiv = document.getElementById('commentList');
				var commentDiv = makeCommentView(comment);
				listDiv.appendChild(commentDiv);
				//등록폼 텍스트필드 클리어
				document.addForm.name.value = '';
				document.addForm.content.value = '';				
				alert("등록했습니다!["+comment.id+"]");
/* 			} else if (code == 'fail') {
				var message = xmlDoc.getElementsByTagName('data')
				                    .item(0).firstChild.nodeValue;
				alert("에러 발생:"+message);
			} */
		} else {
			alert("서버 에러 발생: " + req.status);
		}
	}
}


//수정버튼 이벤트핸들러: 수정할 댓글밑에 수정폼 보이게 함
function viewUpdateForm(commentId) {
	var commentDiv = document.getElementById('c'+commentId); //id값 찾아오기
	var updateFormDiv = document.getElementById('commentUpdate'); //수정폼 찾아오기
	//현재 수정상태(수정폼이 보이고 있음)이면 수정폼이 보이게 할 필요 없음
	if (updateFormDiv.parentNode != commentDiv) { //parentNode함수를 통해서 부모노드 찾아감
		commentDiv.appendChild(updateFormDiv);  //수정폼을 수정할 댓글밑에 보이도록(자식노드를 부모노드에 추가함)
	}
	//부모노드가 갖고 있는 내용을 자식노드에도 보이게 함
	//수정할 값을 텍스트필드에 보이게
	var comment = commentDiv.comment;   //댓글 객체 { id:'', content:'', name:'' }
	document.updateForm.id.value = comment.id;    
	document.updateForm.name.value = comment.name;
	document.updateForm.content.value = comment.content;
	updateFormDiv.style.display = '';   //수정폼 보이게
}


//댓글 수정 ajax 요청
function updateComment() {
	var id = document.updateForm.id.value;
	var name = document.updateForm.name.value;
	var content = document.updateForm.content.value;
	var params = "id="+ id +"&"+
	             "name="+encodeURIComponent(name)+"&"+
	             "content="+encodeURIComponent(content) + "&cmd=update";
	new ajax.xhr.Request('CommentsJsonServ', params, updateResult, 'POST');
}
////댓글 수정 콜백함수
function updateResult(req) {
	if (req.readyState == 4) {
		if (req.status == 200) {
/* 			var xmlDoc = req.responseXML;
			var code = xmlDoc.getElementsByTagName('code').item(0)
			                 .firstChild.nodeValue;
			if (code == 'success') { */
/* 				var comment = eval( "(" +
				    xmlDoc.getElementsByTagName('data').item(0)
				          .firstChild.nodeValue +
				                     ")" ); */
				var comment = eval( "(" + req.responseText + ")" );				
				var listDiv = document.getElementById('commentList');
				var commentDiv = makeCommentView(comment);
	
				var oldCommentDiv = document.getElementById('c'+comment.id);
				//수정폼을 body에 연결
				cancelUpdate();
				
				//새 div와 기존의 div를 교체
				listDiv.replaceChild(commentDiv, oldCommentDiv);
				alert("수정했습니다!");
/* 			} else if (code == 'fail') {
				var message = xmlDoc.getElementsByTagName('data')
				                    .item(0).firstChild.nodeValue;
				alert("에러 발생:"+message);
			} */
		} else {
			alert("서버 에러 발생: " + req.status);
		}
	}
}

//댓글 삭제 ajax 요청
function confirmDeletion(id) {
	var params = "id="+ id +"&cmd=delete";
	new ajax.xhr.Request('CommentsJsonServ', params, deleteResult, 'POST');
}
////댓글 삭제 콜백함수
function deleteResult(req) {
	if (req.readyState == 4) {
		if (req.status == 200) {
/* 			var xmlDoc = req.responseXML;
			var code = xmlDoc.getElementsByTagName('code').item(0)
			                 .firstChild.nodeValue;
			if (code == 'success') {
				var comment = eval( "(" +
				    xmlDoc.getElementsByTagName('data').item(0)
				          .firstChild.nodeValue +
				                     ")" ); */
				var comment = eval( "(" + req.responseText + ")" );
				var listDiv = document.getElementById('commentList');
				
				var commentDiv = document.getElementById('c'+comment.id);
				commentDiv.parentNode.removeChild(commentDiv);
				alert("삭제했습니다!");		
		/* 	} else if (code == 'fail') {
				var message = xmlDoc.getElementsByTagName('data')
				                    .item(0).firstChild.nodeValue;
				alert("에러 발생:"+message);
			} */
		} else {
			alert("서버 에러 발생: " + req.status);
		}
	}
}
//취소 버튼
function cancelUpdate() {
	//수정폼을 body에 연결
    var updateFormDiv = document.getElementById('commentUpdate'); //수정폼 찾아오기
    document.body.appendChild(updateFormDiv); //이동
    updateFormDiv.style.display = 'none'; //안보이게
}
</script>
</head>
<body>
<div id="commentList"></div>

<!-- 댓글등록시작 -->
<div id="commentAdd">
	<form action="" name="addForm">
	이름: <input type="text" name="name" size="10"><br/>
	내용: <textarea name="content" cols="20" rows="2"></textarea><br/>
	<input type="button" value="등록" onclick="addComment()"/>
	</form>
</div>
<!-- 댓글등록끝 -->

<!-- 댓글수정폼시작 -->
<div id="commentUpdate" style="display:none">
	<form action="" name="updateForm">
	<input type="hidden" name="id" value=""/>
	이름: <input type="text" name="name" size="10"><br/>
	내용: <textarea name="content" cols="20" rows="2"></textarea><br/>
	<input type="button" value="등록" onclick="updateComment()"/>
	<input type="button" value="취소" onclick="cancelUpdate()"/>
	</form>
</div>
<!-- 댓글수정폼끝 -->
</body>
</html>






