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
 * Servlet implementation class ServletContextTest4Servlet
 */
@WebServlet("/context4")
public class ServletContextTest4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); //인코딩 방식 설정
		PrintWriter out = response.getWriter();
		//속성을 추출
		ServletContext sc = this.getServletContext();
		String data2 = (String)sc.getAttribute("data2");
		DeptBeans beans = (DeptBeans)sc.getAttribute("공유부서");
		out.print(data2 + "<br>");
		out.print(beans + "<br>");
	}
}
