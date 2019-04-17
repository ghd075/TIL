package com.jogiyo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jogiyo.dao.BoardDAO2;
import com.jogiyo.dao.FoodDAO;
import com.jogiyo.dao.LocationDAO;
import com.jogiyo.vo.BoardDTO;
import com.jogiyo.vo.FoodDTO;
import com.jogiyo.vo.LocationDTO;
import com.jogiyo.vo.MemberDTO;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class sampleController
 */
//@WebServlet("/repleController")
public class PostFormController implements Controller {
	//private static final long serialVersionUID = 1L;
       
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String boardNo = request.getParameter("board_no");
		return "../board/postUpdate.jsp?board_no="+boardNo;
	}

}
