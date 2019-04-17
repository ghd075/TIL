package com.jogiyo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jogiyo.dao.BlackDao;
import com.jogiyo.dao.NoticeDao;
import com.jogiyo.vo.BlackDto;
import com.jogiyo.vo.NoticeDto;

public class AddBlackListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("userid");
	
		BlackDto bdto = new BlackDto();
		bdto.setUserid(userid);
		
		BlackDao bdao = BlackDao.getInstance();
		bdao.insert(bdto);
		
		request.setAttribute("userid", userid);
		
		return "../main/main.jsp";
		
	}
}
