package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet({ "/fst", "/snd" })
public class FirstServlet extends HttpServlet {

	/*
	 * // 클라이언트 요청 처리
	 * 
	 * @Override protected void service(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException { // TODO
	 * Auto-generated method stub System.out.println("service 실행");
	 * response.getWriter().append("servive method"); }
	 * 
	 * // 메모리에서 제거될 때 한 번만 실행(자원해제, DB연결해제)
	 * 
	 * @Override public void destroy() { System.out.println("destroy 실행"); }
	 * 
	 * // 메모리로 로딩될 때 최초 한번만 실행(초기화) - servers 중지했을 때
	 * 
	 * @Override public void init(ServletConfig config) throws ServletException {
	 * System.out.println("init 실행"); }
	 */

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//응답결과의 데이터 타입을 지정(MIME 타입)
		response.setContentType("text/html; charset=UTF-8");
		//데이터를 출력(클라이언트 전송)하기 위한 출력 스트림을 얻는 메서드
		PrintWriter out = response.getWriter(); //output스트림
		out.append("<html>")
			.append("<head><title>응답테스트</title>")
			.append("<script>alert('good morning');</script></head>")
			.append("<body>테스트</body>");
		out.println("</html>");
		out.flush(); //비운다 -> 클라이언트로 결과 전송
		out.close(); //자원해제
		out.print("추가"); //close 이후에는 출력이 안 됨
//		response.getWriter().append("first 서블릿 테스트");
//		response.getWriter().append("get execute");
	}

	@Override protected void doPost(HttpServletRequest request,
	  HttpServletResponse response) throws ServletException, IOException 
	{ // TODOAuto-generated method 
		response.getWriter().append("post execute"); 
	}

}
