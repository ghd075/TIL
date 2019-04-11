<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>windows_test.jsp</title>
<script>
var info = navigator.userAgent.toLocaleLowerCase();
var osImg = null;

if(info.indexOf('windows') >= 0) {
	osImg = "windows.png";
} else if(info.indexOf('macintosh') >= 0) {
	osImg = "macintosh.png";
} else if (info.indexOf('iPhone') >= 0) {
	osImg = "iphone.png";
} else if (info.indexOf('android') >= 0) {
	osImg = "android.png";
}

document.write("<img src=\"../images/" + osImg + "\">", "<br>");
var scr = screen;
var sc_w = scr.width;
var sc_h = scr.height;

document.write("모니터 해상도 너비 : " + sc_w + "px", "<br>");
document.write("모니터 해상도 높이 : " + sc_h + "px", "<br>");
</script>
</head>
<body>

</body>
</html>