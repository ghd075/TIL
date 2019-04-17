package com.jogiyo.controller.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jogiyo.controller.Controller;
import com.jogiyo.dao.BlackDao;
import com.jogiyo.dao.LoginDAO;
import com.jogiyo.dao.memberDAO;


public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		//아이디와 비밀번호를 가져온다.
		String userid = request.getParameter("userID");
		String password = request.getParameter("userPassword");
		//DB에서 아이디, 비밀번호 확인
		LoginDAO dao = LoginDAO.getInstance();
		//아이디 차단
		if(BlackDao.getInstance().getId(userid) != null) {
			out.print("<script>alert('아이디가 차단되었습니다.');");
			out.print("location='../member/LoginForm.do';");
			out.print("</script>");
			return null;
		}
		int check = dao.loginCheck(userid, password);
		if(check == 0) { //비밀번호 틀릴경우 -> 다시 로그인 화면으로 이동
			// 로그인 실패시 메시지를 request에 담는다.
			out.print("<script>alert('비밀번호가 틀렸습니다.');");
			out.print("location='../member/LoginForm.do';");
			out.print("</script>");
		}else if(check == -1) { // 아이디가 없을 경우 -> 다시 로그인 화면으로 이동
			out.print("<script>alert('아이디가 없습니다.');");
			out.print("location='../member/LoginForm.do';");
			out.print("</script>");
		}else {
			//로그인 성공 -> 세션에 아이디를 저장
	   		session.setAttribute("sessionID", userid);
	   		session.setAttribute("sessionUser_code", memberDAO.getInstance().getUserInfo(userid).getUser_code());
	   		return "redirect:../main/MianForm.do";
		}
		return null;
	}
	
}
