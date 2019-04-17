package com.jogiyo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jogiyo.dao.BlackDao;
import com.jogiyo.dao.NoticeDao;
import com.jogiyo.vo.BlackDto;
import com.jogiyo.vo.NoticeDto;

public class DeleteBlackListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Parameter 추출
		String userid = request.getParameter("userid");
		
		//데이타 바인딩
		BlackDto bdto = new BlackDto();
		bdto.setUserid(userid);
	
		BlackDao bdao = BlackDao.getInstance();
		bdao.delete(bdto);
		
		//뷰페이지로이동
		request.setAttribute("userid", userid);
		return "../main/main.jsp";		
	}
}
