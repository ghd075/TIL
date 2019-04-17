package com.jogiyo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jogiyo.dao.NoticeDao;
import com.jogiyo.vo.NoticeDto;

public class NoticeUpdateFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	 	String notice_no = request.getParameter("notice_no");
	 	NoticeDto dto = NoticeDao.getInstance().getNotice(notice_no);
	 	request.setAttribute("notice", dto);
		return "noticeUpdate.jsp";
	}
	
}
