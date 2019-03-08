package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LocalTestServlet
 */
@WebServlet("/local")
public class LocalTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String str;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 지역변수
		int number = 0;
		str = request.getParameter("msg");
		response.setContentType("text/html;charset=UTF-8"); //인코딩 방식 설정
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>MultiThread Test</title></head>");
		out.println("<body><h2>처리 결과(지역 변수)</h2>");
		while (number++ < 10) { //10번 반복실행
			out.print(str + " : " + number + "<br>");
			out.flush(); //버퍼를 전송
			System.out.println(str + " : " + number);
			try {
				Thread.sleep(1000); //1초간 대기
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		out.println("<h2>Done " + str + " !!</h2>");
		out.println("</body></html>");
		out.close();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
