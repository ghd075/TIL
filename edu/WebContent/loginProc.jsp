<%@page import="com.edu.member.LoginDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%	
	//로그인/로그아웃 처리
	String method = request.getMethod(); //요청방식(대문자로 가져온다.)
	if(method.equals("POST")){ //로그인처리
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		if (LoginDAO.getInstance().loginCheck(userId, userPw)) {
			//세션에 로그인 정보 저장
			session.setAttribute("userId", userId);
			//response.sendRedirect("login2.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("login2.jsp"); //RequestDispatcher객체 생성
			rd.forward(request, response); //페이지 이동(request 전달)
		} else {
			//response.sendRedirect("login.jsp");
			request.setAttribute("msg", "아이디 오류"); //setAttribute로 값을 저장하고 (getAttribute는 login.jsp 페이지에서 구현하였으며 페이지가 이동하였으며 forward()메서드를 사용하여 값이 페이지를 이동할 수 있게 하였음)
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response); 
		}
	}else{ //로그아웃처리
		session.invalidate(); //세션제거
		out.print("<script>");
		out.print("alert('로그아웃 작업이 완료되었습니다.');");
		out.print("location='login.jsp'"); //자바스크립트에서 페이지 이동
		out.print("</script>");
	}
%>
