<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sessionListenerTest.jsp</title>
</head>
<body>
	세션 생성<br>
	<%
	String param = request.getParameter("p");
	if(param == null){
		out.print("세션 생성");
	}else if(param.equals("delete")){
		session.invalidate();
		out.print("세션 객체 삭제 작업 완료");
	}else if(param.equals("add")){
		session.setAttribute("msg", "속성 추가");
		out.print("세션에 속성 추가");
	}else if(param.equals("remove")){
		session.removeAttribute("msg");
		out.print("세션에 속성 삭제");
	}else if(param.equals("replace")){
		session.setAttribute("msg", "속성 변경");
		out.print("세션에 속성 변경");
	}
	%>
</body>
</html>