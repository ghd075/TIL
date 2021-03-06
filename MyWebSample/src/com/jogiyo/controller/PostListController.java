package com.jogiyo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jogiyo.dao.HjhDAO;
import com.jogiyo.vo.HjhDTO;
import com.web.common.Paging;

public class PostListController implements Controller {

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Paging paging = new Paging();
		ArrayList<HjhDTO> list = null;
		try {	
			String desc = request.getParameter("a");//jsp에서 a,p값을 요청
			String sp = request.getParameter("p");
			int p = 1;
			if(sp != null && ! sp.isEmpty()){
				p = Integer.parseInt(sp);
			}
		
		paging.setPage(p); // 현재페이지
		paging.setPageUnit(10);
		paging.setPageSize(5); 
		paging.setTotalRecord(HjhDAO.getInstance().count_b(desc)); //HjhDAO에서 전체 레코드 건수를 기록한다
		
		int first = paging.getFirst();
		int last = paging.getLast();
		
		list = HjhDAO.getInstance().PostList(first, last, desc); // HjhDAO에서 넘어오는 변수들을 리스트에 담는다.
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		//
		request.setAttribute("paging", paging);
		request.setAttribute("list", list);
		//HttpUtil.forward(request, response, "/result/memberListOutput.jsp");
		return "/admin/postHandle.jsp";
	}

}
