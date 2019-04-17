package com.jogiyo.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jogiyo.controller.Controller;
import com.jogiyo.dao.memberDAO;
import com.jogiyo.vo.MemberDTO;

public class MemberInfoController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//세션이 가지고 있는 로그인한 ID정보를 가져온다.
		HttpSession session = request.getSession();
		String id = session.getAttribute("sessionID").toString();
		
		//그 아이디에 해당하는 회원정보를 가져온다.
		MemberDTO member = memberDAO.getInstance().getUserInfo(id);
		
		// MemberInfoForm.jsp에 회원정보를 전달하기 위해 request에 MemberDTO을 세팅한다.
		request.setAttribute("memberInfo", member);
		return "../member/MemberInfoForm.jsp";
	}

}
