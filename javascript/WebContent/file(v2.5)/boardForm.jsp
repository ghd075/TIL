<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="../ckeditor/ckeditor.js"></script>
</head>
<body>
<form>
	<input type="text" name="title" /><br>
	<textarea rows="3" cols="40" id="contents" name="contents"></textarea><br>
	<script>
		CKEDITOR.replace('contents',{
				language: 'ko', //언어변경
				uiColor: '#9AB8F3', //ur색깔 변경
				filebrowserUploadUrl: '<%=request.getContextPath()%>/ckeditor/fileUpload.jsp'
			});
	</script>
	<!-- opener.document.forms[0].(name속성 값).value -->
	<!-- name값과 document에서 불러오는 name값과 일치해야 함 -->
	<input type="text" name="attachFile" /><input type="button" onclick="window.open('fileUploadForm.jsp','file', 'width=200,height=200')" value="파일업로드"/><br>
	<input type="submit" value="저장" />
</form>
</body>
</html>