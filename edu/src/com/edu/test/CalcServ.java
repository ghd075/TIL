package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServ
 */
@WebServlet("/CalcServ")
public class CalcServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
	
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");;
		String op = request.getParameter("op");;
		int result = 0;
		
		int n1 = Integer.parseInt(num1);
		int n2 = Integer.parseInt(num2); 
		
		//계산기
		switch (op) {
		case "+":
			result = n1 + n2;
			break;
		case "-":
			result = n1 - n2;
			break;
		case "X":
			result = n1 * n2;
			break;
		case "/":
			try {
				result = n1 / n2;
			}catch (ArithmeticException e) {
				System.out.println("Error! : 값에 0이 입력되어서 실행오류 발생");
			}
			break;
		default:
			break;
		}			
		//파라미터 받아서 계산
		out.print("num1 = " + num1 + "<br>" );
		out.print("num2 = " + num2 + "<br>");
		out.print("op = " + op + "<br>");
		out.print("계산결과 = " + result + "<br>" );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
