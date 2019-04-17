package com.jogiyo.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jogiyo.controller.Controller;
import com.jogiyo.dao.memberDAO;
import com.jogiyo.vo.MemberDTO;

public class MemberModifyController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //인코딩
		
		// 세션이 가지고있는 로그인한 ID 정보를 가져온다
		HttpSession session = request.getSession();
		String id = session.getAttribute("sessionID").toString();
		
		//수정할 정보를 DTO에 세팅한다.
		MemberDTO member = new MemberDTO();
		member.setId(id);
		member.setPassword(request.getParameter("password"));
		member.setPhone(request.getParameter("phone"));
		member.setAddress(request.getParameter("address"));
		
		memberDAO.getInstance().update(member);
		
		return "redirect:../main/MianForm.do";
	}

}
