package com.jogiyo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jogiyo.dao.BoardDAO2;
import com.jogiyo.dao.RepleDAO;
import com.jogiyo.vo.BoardDTO;
import com.jogiyo.vo.RepleDTO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class sampleController
 */
//@WebServlet("/repleController")
public class PostDeleteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int r = 0;
		try {
			BoardDTO bean = new BoardDTO();
			bean.setBoard_no(boardNo);
			r = BoardDAO2.getInstance().delete(bean);
			out.print(JSONArray.fromObject(r));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
