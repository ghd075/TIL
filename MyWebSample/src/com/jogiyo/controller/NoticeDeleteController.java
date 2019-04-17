package com.jogiyo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jogiyo.dao.NoticeDao;
import com.jogiyo.vo.NoticeDto;

public class NoticeDeleteController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Parameter 추출
		String notice_no = request.getParameter("notice_no");
		
		//데이타 바인딩
		NoticeDto ndto = new NoticeDto();
		ndto.setNotice_no(notice_no);
	
		NoticeDao ndao = NoticeDao.getInstance();
		ndao.delete(ndto);
		
		//뷰페이지로이동
		request.setAttribute("notice_no", notice_no);
		return "../main/main.jsp";
	}		
}
