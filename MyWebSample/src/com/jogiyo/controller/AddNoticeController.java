package com.jogiyo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jogiyo.dao.NoticeDao;
import com.jogiyo.vo.NoticeDto;

public class AddNoticeController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Parameter 추출
		String notice_no = request.getParameter("notice_no");
		String notice_title = request.getParameter("notice_title");
		String notice_contents = request.getParameter("notice_contents");
		String n_date = request.getParameter("n_date");
		
		//데이타 바인딩
		NoticeDto ndto = new NoticeDto();
		ndto.setN_date(n_date);
		ndto.setNotice_contents(notice_contents);
		ndto.setNotice_no(notice_no);
		ndto.setNotice_title(notice_title);
		
		NoticeDao ndao = NoticeDao.getInstance();
		ndao.insert(ndto);
		
		//뷰페이지로이동
		request.setAttribute("notice_no", notice_no);
		return "../main/main.jsp";
	}			
}
