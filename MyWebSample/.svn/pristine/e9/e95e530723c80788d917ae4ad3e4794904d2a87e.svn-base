package com.jogiyo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jogiyo.dao.RepleDAO;
import com.jogiyo.vo.MemberDTO;
import com.jogiyo.vo.RepleDTO;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class sampleController
 */
//@WebServlet("/repleController")
public class EvaluationController implements Controller {
	//private static final long serialVersionUID = 1L;
       
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		int bno = Integer.parseInt(request.getParameter("bNo"));
			 
		//목록
		try {
			RepleDTO bean = new RepleDTO();
			MemberDTO mbean = new MemberDTO();
			bean.setBoardNo(bno);
			mbean.setId(userId);
			List<HashMap<String, Object>> list  = RepleDAO.getInstance().checkEval(bean, mbean);
			out.print(JSONArray.fromObject(list));
			//out.print(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}

}
