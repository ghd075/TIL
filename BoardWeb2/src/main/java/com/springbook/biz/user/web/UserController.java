package com.springbook.biz.user.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

@Controller
public class UserController {
	
	@Autowired
	UserService servie;
	
	//로그인폼
	@RequestMapping(value= {"/loginForm", "/login"},method=RequestMethod.GET)
	public String loginForm() {
		return "login";
	}
	
	//로그인 처리
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@ModelAttribute("user") UserVO vo, 
						HttpServletRequest request, 
						HttpSession session) {
		//커맨드 객체는 자동으로 model.addAttribute("user", vo)
		UserVO user = servie.getUser(vo); 
		if( user == null)
			return "login";
		else {
			session.setAttribute("userName", user.getName());
			session.setAttribute("Id", user.getId());
			session.setAttribute("user", user);
			return "redirect:boardList";
		}
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); //세션 무효화
		return "login";
	}
	//회원 목록 조회
	@RequestMapping("/getUserList")
	//public String getUserList(Model model, UserVO vo) {
		//model.addAttribute("userList", servie.getUserList());
		//model.addAttribute("userList", servie.getUserMap(vo));
		//return "user/userList";
	//}
	//Controller의 리턴타입
	public ModelAndView getUserList(ModelAndView mv, UserVO vo) {
		mv.addObject("userList", servie.getUserMap(vo));
		mv.setViewName("user/userList");
		return mv;
	}	
}
