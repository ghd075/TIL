package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContextTest
 */
@WebServlet("/ServletContextTest") //p197
public class ServletContextTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); //인코딩 방식 설정
		PrintWriter out = response.getWriter();
		
		ServletContext sc = this.getServletContext(); //웹어플리케이션(서버)이 시작되면 자동 생성
		out.print("서버명 : " + sc.getServerInfo()+"<br>");
		out.print("버전 : " + sc.getMajorVersion() + "."  + sc.getMinorVersion()+"<br>");
		out.print("컨텍스트패스 : " + sc.getContextPath()+"<br>");
		out.print("어플리케이션이름 : " + sc.getServletContextName()+"<br>");
		out.print("실제경로 : " + sc.getRealPath("/application.jsp")+"<br>");
		out.close();
	}
}
