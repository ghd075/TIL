package com.jogiyo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jogiyo.dao.RepleDAO;
import com.jogiyo.vo.RepleDTO;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class sampleController
 */
//@WebServlet("/repleController")
public class DisplayCommentController implements Controller {
	//private static final long serialVersionUID = 1L;
       
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String cmd = request.getParameter("cmd");
		RepleDTO bean = new RepleDTO(); 
		bean.setBoardNo(Integer.parseInt(request.getParameter("boardNo")));
		if (cmd.equals("selectAll")) {
			//목록
			try {
				List<HashMap<String, Object>> list = RepleDAO.getInstance().selectAll(bean);
				
				out.print(JSONArray.fromObject(list));
				//out.print(list);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return null;
	}

}
