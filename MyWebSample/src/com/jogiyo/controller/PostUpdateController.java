package com.jogiyo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jogiyo.dao.BoardDAO2;
import com.jogiyo.vo.BoardDTO;

/**
 * Servlet implementation class sampleController
 */
//@WebServlet("/repleController")
public class PostUpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//String cmd = request.getParameter("cmd");
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String loc_code = request.getParameter("loc_code");
		String food_code = request.getParameter("food_code");
		String title = request.getParameter("title");
		String board_text = request.getParameter("contents");

		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String curTime = f.format(date);
		
		BoardDTO bean = new BoardDTO();
		bean.setBoard_no(boardNo);
		bean.setLoc_code(loc_code);
		bean.setFood_code(food_code);
		bean.setTitle(title);
		bean.setBoard_text(board_text);
		bean.setBoard_date(curTime);
		int r = 0;
		try { 
			r = BoardDAO2.getInstance().update(bean);
		} catch(Exception e) {
			e.printStackTrace();
		}
		if (r == 0) {
			out.print("<script>alert('수정이 실패되었습니다.');location.href='commentPost.jsp?board_no="+Integer.toString(boardNo)+"';</script>");
		} else {		
			out.print("<script>alert('수정되었습니다.'); location.href='commentPost.jsp?board_no="+Integer.toString(boardNo)+"';</script>");
		}
		return null;
	}
}
