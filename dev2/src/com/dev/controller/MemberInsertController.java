package com.dev.controller;
/*
 * 회원 등록 처리하는 컨트롤러
 */
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class MemberInsertController implements Controller {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Parameter 추출
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");

		// 유효성 체크
		if (id.isEmpty() || passwd.isEmpty() || name.isEmpty() || mail.isEmpty()) {
			request.setAttribute("error", "모든 항목을 빠짐없이 입력해주시기 바랍니다!");
			return "/memberInsert.jsp";
		}

		// VO객체에 데이타 바인딩
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPasswd(passwd);
		member.setName(name);
		member.setMail(mail);

		// Service 객체의 메서드 호출
		MemberService service = MemberService.getInstance();
		service.memberInsert(member);

		// Output View 페이지로 이동
		request.setAttribute("id", id);
		return "/result/memberInsertOutput.jsp";
	}
}
