<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String board_no = request.getParameter("board_no"); 
int bNo = Integer.parseInt(board_no);
String userId = "";

try {
	userId = session.getAttribute("sessionID").toString();	
} catch (NullPointerException e) {
	userId = "";
	// TODO: handle exception
}

if (userId == "" ||userId.equals("")) {
%>
<script>
	alert("로그인이 필요합니다.");
	location.href = "../member/LoginForm.do";
</script>
<%
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정하기</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src = "../js/ajax.js"></script>
<script src="../ckeditor/ckeditor.js"></script>
<script>
function loadContents() {
	var userId = "<%=userId %>";
	var bno = <%= bNo %>;
	var params = "boardNo="+ bno+"&"+
				"userId="+userId;
	new ajax.xhr.Request("displayBoard.do", params, contentsResult, 'GET');
}

function contentsResult(req) {
	if (req.readyState == 4) {    //응답이 완료
		if (req.status == 200) {  //정상실행
			console.log("게시글 로드");
			console.log(JSON.parse(req.responseText));
		
			var rs = JSON.parse(req.responseText);

			var title = rs[0].title;
			var foodCode = rs[0].foodCode;
			var locCode= rs[0].locCode;
			var boardText = rs[0].boardText;
		
			$("input[name=title]").val(title);			
			$("select[name=loc_code]").val(locCode);
			$("select[name=food_code]").val(foodCode);
			$("textarea[name=contents]").val(boardText);
			
			CKEDITOR.replace('contents',{
				language: 'ko', //언어변경				
				uiColor: '#9AB8F3', //ur색깔 변경
				filebrowserUploadUrl: '<%=request.getContextPath()%>/ckeditor/fileUpload.jsp'
			});			
			//CKEDITOR.instances.contents.setData(boardText);
		}
	}	
}

</script>
</head>
<body>
<%@include file="../main/header.jsp"%>
<article>
	<div class="container" role="border">
		<h2>글 수정하기</h2>
		<br>
		<form action="updateBoard.do" method="post" name="writePost">
			<div class="mb-3">
				<select name="loc_code">
					<option value="">지역선택</option>
					<option value="l01">서울특별시</option>
					<option value="l02">대구광역시</option>
					<option value="l03">부산광역시</option>
					<option value="l04">인천광역시</option>
					<option value="l05">광주광역시</option>
					<option value="l06">대전광역시</option>
					<option value="l07">울산광역시</option>
					<option value="l08">세종특별시</option>
					<option value="l09">제주특별시</option>
				</select>
				<select name="food_code" style="margin-left: 10px">
					<option value="">음식선택</option>
					<option value="f01">한식</option>
					<option value="f02">중식</option>
					<option value="f03">피자/양식</option>
					<option value="f04">일식/돈까스</option>
					<option value="f05">패스트푸드</option>
					<option value="f06">치킨</option>
					<option value="f07">족발/보쌈</option>
					<option value="f08">분식</option>
				</select>
			</div>
			<div class="mb-3">
				<label for="title">제목</label>
				<input type="text" class="form-control" name="title" placeholder="제목을 입력해 주세요">
			</div>
			<div class="mb-3">
				<label for="contents">내용</label>
				<textarea class="form-control" rows="5" id="contents" name="contents" placeholder="내용을 입력해 주세요"></textarea>
				<script>
				loadContents();				
				</script>			
			</div>
			<div>
				<input type="hidden" name="boardNo" value="<%=bNo%>"/>
				<button type="submit" class="btn btn-sm btn-primary">저장</button>
				<button type="button" class="btn btn-sm btn-primary" onclick="javascript:window.location='commentPost.jsp?board_no=<%=bNo%>'">취소</button>
			</div>
		</form>
	</div>
</article>
<br><br>
<%@include file="../main/footer.jsp"%>
</body>
</html>