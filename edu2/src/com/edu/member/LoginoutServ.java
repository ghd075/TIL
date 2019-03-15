package com.edu.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.edu.common.CookieBox;

/**
 * Servlet implementation class LoginoutServ
 */
@WebServlet("/loginoutServ")  // '/edu/'에 연결되는 구조
public class LoginoutServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	//로그아웃처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(); //클라이언트로부터 세션정보를 가져온다.
		session.invalidate(); //세션 무효화
		response.sendRedirect("main/main.jsp"); //login.jsp페이지로 이동
	}
	
	//로그인처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); //인코딩 방식 설정
		String id = request.getParameter("userid");
		String pw = request.getParameter("userpw");
		
		boolean result = LoginDAO.getInstance().loginCheck(id, pw);
		if(result == true) { //로그인 된 경우
			//쿠키(id 저장)
			// idSave 파라미터값이 NULL이 아니고 'y'라면 userid 파라미터값을 쿠키에 저장
			String idSave = request.getParameter("idSave");
			if((idSave!=null) && (idSave.equals("y"))) {
				Cookie c1 = CookieBox.createCookie("idSave", id,"/",60*60);
				response.addCookie(c1);
			}
			HttpSession session = request.getSession(); //클라이언트로부터 세션정보를 가져온다.
			session.setAttribute("userid", id);
			response.sendRedirect("main/main.jsp");
		}else {
			
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('로그인 실패하였습니다.');");
			out.print("location='main/main.jsp'");
			out.print("</script>");		
		}
		System.out.println("로그인 서블릿 실행");
		
	}

}
