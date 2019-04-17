package com.jogiyo.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jogiyo.dao.StatisDao;

import net.sf.json.JSONArray;

@WebServlet("/CntFoodServ")
public class CntFoodServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CntFoodServ() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html); charset=utf-8");
		PrintWriter out = response.getWriter();
		List<Map<String,Object>> list = StatisDao.getInstance().selectFood();
		out.print(JSONArray.fromObject(list));
		
	}
}
