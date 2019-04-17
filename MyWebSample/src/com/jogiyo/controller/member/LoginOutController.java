package com.jogiyo.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jogiyo.controller.Controller;

public class LoginOutController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 로그아웃시 세션에 담긴 아이디 값을 삭제한다.
		request.getSession().removeAttribute("sessionID");
		return "redirect:../main/MianForm.do";
	}

}
