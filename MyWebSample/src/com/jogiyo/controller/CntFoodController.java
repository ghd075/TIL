package com.jogiyo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jogiyo.dao.StatisDao;

import net.sf.json.JSONArray;

public class CntFoodController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		List<Map<String,Object>> list = StatisDao.getInstance().selectFood();
		out.print(JSONArray.fromObject(list));
		
		return null;
	}
}
