package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LiginServ
 */
@WebServlet("/LoginServ")
public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * // TODO Auto-generated method stub response.getWriter().append("get 로그인 완료");
		 * System.out.println(request.getParameter("userId"));
		 */
		//응답결과의 데이터 타입을 지정(MIME 타입)
		response.setContentType("text/html; charset=UTF-8");
		//데이터를 출력(클라이언트 전송)하기 위한 출력 스트림을 얻는 메서드
		PrintWriter out = response.getWriter();
		//쿼리문자열 읽기
		out.print("query String : " + request.getQueryString() + "<br>");
		//파라미터 개별
		out.print("userId : " + request.getParameter("userId") + "<br>");
		//전체 파라미터
		//String타입으로 열거형 변수를 선언하고 파라메터이름을 저장해라
		Enumeration<String> params = request.getParameterNames();
		out.print("<hr>");
		//열거타입의 데이터가 있을 때까지 반복해라
		while(params.hasMoreElements()) {
			String param_name = params.nextElement(); //다음 요소를 갖고와라
			String param_value = request.getParameter(param_name); //요소에 해당되는 값을 갖고와라
			out.print(param_name + " : " + param_value + "<br>"); //그 정보들을 출력
		}
		
		out.print("<hr>");
		//맵으로 전체 파라미터 조회
		Map<String, String[]> maps = request.getParameterMap();
		Set<String> keys = maps.keySet();
		Iterator<String> iter = keys.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			String[] value = maps.get(key);
			out.print(key + " : " + value[0] + "<br>");
		}
		//로그인 처리
		if(request.getParameter("userId").equals("admin")) {
			out.print("login success");
//			response.sendRedirect("index.jsp");
		}else {
		//로그인이 안 될 경우 로그인 페이지 이동
			out.print("login fail");
//			response.sendRedirect("login.jsp");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("post 로그인 완료");
		System.out.println(request.getParameter("userId"));
	}

}
