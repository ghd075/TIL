package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.deptBeans.DeptBeans;

/**
 * Servlet implementation class ServletContextTest3Servlet
 */
@WebServlet("/context3")
public class ServletContextTest3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); //인코딩 방식 설정
		PrintWriter out = response.getWriter();
		
		//컨텍스트에 속성을 추가(모든 페이지나 서블릿에서 접근가능)
		ServletContext sc = this.getServletContext();
		sc.setAttribute("공유부서", new DeptBeans("10","총무","",""));
		sc.setAttribute("data2", "공유값");
	    String data2 = (String)sc.getAttribute("data2");
	    DeptBeans beans = (DeptBeans)sc.getAttribute("공유부서");
	}
}
