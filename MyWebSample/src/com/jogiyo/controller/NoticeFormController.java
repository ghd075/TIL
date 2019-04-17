package com.jogiyo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jogiyo.dao.NoticeDao;
import com.jogiyo.vo.NoticeDto;


public class NoticeFormController implements Controller{
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//파라미터 받고
		String notice_no = request.getParameter("notice_no");
		//서비스(db처리)
		NoticeDto ndto = NoticeDao.getInstance().getNotice(notice_no);
		//결과를 저장
		request.setAttribute("ndto1", ndto);
		//포워드 될 페이지명을 리턴
		return "../WebContent/notice/noticeUpdate.jsp";
	}
}
