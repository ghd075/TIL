package com.jogiyo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class RepleUpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String cmd = request.getParameter("cmd");		
		if (cmd.equals("update")) {
			try {
				SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date();
				String curTime = f.format(date);
				
				RepleDTO bean = new RepleDTO();

				bean.setRepleNo(Integer.parseInt(request.getParameter("repleNo")));
				bean.setRepleText(request.getParameter("cmtUpdate"));
				bean.setReDate(curTime);
				
				HashMap<String, Object> map = RepleDAO.getInstance().update(bean);
				out.print(JSONObject.fromObject(map));
			} catch(Exception e) {
				e.printStackTrace();
			}
		}		
		return null;
	}

}
