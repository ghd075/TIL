package com.jogiyo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jogiyo.dao.BlackDao;
import com.jogiyo.dao.NoticeDao;
import com.jogiyo.vo.BlackDto;
import com.jogiyo.vo.NoticeDto;
import com.jogiyo.vo.NoticeSelectDto;

public class NoticeSelectController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		NoticeDao ndao = NoticeDao.getInstance();
		NoticeDto ndto = ndao.SelectNotice();
		
		request.setAttribute("notice", ndto);		
		//return "../notice/notice2.jsp";
		return "notice2.jsp";
		
	}
}
