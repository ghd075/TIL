package com.edu.deptBeans;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class insertDeptServ
 */
/*
 * @WebServlet( urlPatterns = { "/insertDeptServ", "/deptinert" }, initParams =
 * {
 * 
 * @WebInitParam(name = "username", value = "admin") })
 */
public class insertDeptServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config); //부모클래스의 init메소드 호출해야 NullPoint오류가 발생하지 않음
		System.out.println(config.getInitParameter("username"));
		System.out.println(config.getInitParameter("password"));		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("초기화 파라미터 연습");
		//자신 서블릿에서 설정한 초기화 파라미터만 접근가능
		out.print(this.getInitParameter("password"));
		//컨텍스트(=애플리케이션) 파라미터 -> 모든 서블릿, JSP에서 접근 가능
		ServletContext sc = this.getServletContext();
		out.print(sc.getInitParameter("encoding"));
	}

}
