package com.dev.controller;
/*
 * 모든 회원 정보 조회 처리하는 컨트롤러
 */
import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dev.service.MemberService;
import com.dev.vo.MemberVO;

public class MemberListController implements Controller {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = MemberService.getInstance();
		ArrayList<MemberVO> list = service.memberList();
		
		request.setAttribute("list", list);
		return "/result/memberListOutput.jsp";
	}
}
