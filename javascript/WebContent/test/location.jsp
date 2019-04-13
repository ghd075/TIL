<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>location.jsp</title>
<style>
	span {
		cursor: pointer;
		background-color: gray;
		color: wite;
	}
	span:hover {
		background-color: yellow;
	}
</style>
<script type="text/javascript">
	function func(newFile) {
		document.getElementById("a_iframe").src = newFile;
	}
</script>
</head>
<body>
<h4>location 연습</h4>
<span onclick="func('window.jsp')">window.jsp</span>
<span onclick="func('timer_imageSlider.jsp')">timer_imageSlider.jsp</span>
<span onclick="func('memberList.jsp')">memberList.jsp</span>
<iframe src="" id="a_iframe"></iframe>
</body>
</html>