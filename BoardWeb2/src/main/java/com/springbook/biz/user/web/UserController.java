package com.springbook.biz.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

@Controller
public class UserController {
	
	@Autowired
	UserService servie;
	
	//로그인폼
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "login";
	}
	
	//로그인 처리
	@RequestMapping("/login")
	public String login(UserVO vo) {
		if(servie.getUser(vo) == null)
			return "login";
		else
			return "redirect:boardList";
	}
	
	//회원 목록 조회
	@RequestMapping("/getUserList")
	public String getUserList(Model model, UserVO vo) {
		//model.addAttribute("userList", servie.getUserList());
		model.addAttribute("userList", servie.getUserMap(vo));
		return "user/userList";
	}
}
