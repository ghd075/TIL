package com.jogiyo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jogiyo.dao.RepleDAO;
import com.jogiyo.vo.RepleDTO;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class sampleController
 */
//@WebServlet("/repleController")
public class RepleDeleteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String cmd = request.getParameter("cmd");		
		if (cmd.equals("delete")) {
			try {
				//빈을 생성해서 파라미터를 빈에 담기
				RepleDTO bean = new RepleDTO();
				bean.setRepleNo(Integer.parseInt(request.getParameter("repleNo")));
				HashMap<String, Object> map = RepleDAO.getInstance().delete(bean);
				out.print(JSONObject.fromObject(map));
			} catch (Exception e) {
				e.printStackTrace();
				//out.print(toXML("error", e.getMessage()));
			}
		}
		return null;
	}

}
