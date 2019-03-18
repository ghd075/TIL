package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorHandleServlet
 */
@WebServlet("/errorHandle")
public class ErrorHandleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Integer code = (Integer) request.getAttribute("javax.servlet.error.status_code");
		String message = (String) request.getAttribute("javax.servlet.error.message");
		Object type = request.getAttribute("javax.servlet.error.exception_type");
		Throwable exception = (Throwable) request.getAttribute("javax.servlet.error.exception");
		String uri = (String) request.getAttribute("javax.servlet.error.request_uri");
		
		out.print("<h2>Error Code : " + code + "</h2>");
		out.print("<h2>Error Message : " + message + "</h2>");
		out.print("<h2>Error Type : " + type + "</h2>");
		out.print("<h2>Error Object : " + exception + "</h2>");
		out.print("<h2>Error URI : " + uri + "</h2>");
		
		out.close();
	}
}
