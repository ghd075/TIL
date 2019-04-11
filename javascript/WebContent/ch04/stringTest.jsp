<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>stringTest.jsp</title>
<script>
        var phoneNum = "010-2345-1234";
        var result_1 = phoneNum.substring(phoneNum.length-4,0);
        document.write(result_1, "**** <br>");
    
        var imgSrc = "../images/bnt_out.jpg";
        var result_2 = imgSrc.replace("out.jpg","over.jpg");
        document.write(result_2, "<br>");
    </script>
</head>
<body>

</body>
</html>