package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DdayServ
 */
@WebServlet("/DdayServ")
public class DdayServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DdayServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Calendar cal = Calendar.getInstance();
		//날짜입력값을 받아서 남은 일수 계산 
		Date today = new Date();
		long day1 = today.getTime();
		String dday = request.getParameter("dday");
		String[] day2 = dday.split("-");
		int y = Integer.parseInt(day2[0]);
		int m = Integer.parseInt(day2[1]);
		int d = Integer.parseInt(day2[2]);
		cal.set(y, m, d);
		long cnt = day1 - cal.getTimeInMillis();
		
		out.print("남은일수는 " + cnt/1000/60/60/24);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
