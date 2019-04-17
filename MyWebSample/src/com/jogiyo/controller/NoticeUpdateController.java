package com.jogiyo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jogiyo.dao.NoticeDao;
import com.jogiyo.vo.NoticeDto;

public class NoticeUpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Parameter 추출
		String notice_no = request.getParameter("notice_no");
		String notice_title = request.getParameter("notice_title");
		String notice_contents = request.getParameter("notice_contents");
		System.out.println(notice_no);
		System.out.println(notice_title);
		System.out.println(notice_contents);
		
		
		//데이타 바인딩
		NoticeDto ndto = new NoticeDto();
		ndto.setNotice_no(notice_no);
		ndto.setNotice_title(notice_title);
		ndto.setNotice_contents(notice_contents);
		
		NoticeDao ndao = NoticeDao.getInstance();
		ndao.update(ndto);
		
		//뷰페이지로이동
		request.setAttribute("notice_no", notice_no);
		return "../main/main.jsp";
	}
	
}
