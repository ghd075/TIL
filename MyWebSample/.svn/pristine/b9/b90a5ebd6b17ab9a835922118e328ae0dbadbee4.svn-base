package com.jogiyo.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jogiyo.controller.Controller;
import com.jogiyo.dao.memberDAO;
import com.jogiyo.vo.MemberDTO;

public class MemberInsertController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// Parameter 추출
		String name = request.getParameter("userName");
		String id = request.getParameter("userID");
		String password = request.getParameter("userPassword");
		String phone = request.getParameter("userPhone");
		String address = request.getParameter("userAddress");

		// 입력된 정보를 DTO에 세팅한다.
		MemberDTO member = new MemberDTO();
		member.setUser_name(name);
		member.setId(id);
		member.setPassword(password);;
		member.setPhone(phone);
		member.setAddress(address);
		
		// MemberDAO 객체의 메서드 호출
		memberDAO.getInstance().insert(member);
		
		// 메인 페이지로 이동
		return "redirect:../main/MianForm.do";
	}
}
