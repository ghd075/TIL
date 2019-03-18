package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ContextListenerTest
 */
@WebServlet("/ContextListenerTest")
public class ContextListenerTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		//서블릿에서 내장객체 얻는 방법
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		ServletContext application = this.getServletContext();
		String param = request.getParameter("p");
		if(param == null){
			out.print("세션 생성");
		}else if(param.equals("add")){
			application.setAttribute("msg", "속성 추가");
			out.print("어플리케이션에 속성 추가");
		}else if(param.equals("remove")){
			application.removeAttribute("msg");
			out.print("어플리케이션에 속성 삭제");
		}else if(param.equals("replace")){
			application.setAttribute("msg", "속성 변경");
			out.print("어플리케이션에 속성 변경");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
