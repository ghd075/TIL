package com.edu.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;


/**
 * Servlet implementation class insertMemberServ
 */
@WebServlet("/insertMember")
public class insertMemberServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//파라미터를 빈즈에 담고 (<jsp:useBean />, <jsp:setProperty />)
		MemberDTO beans = new MemberDTO(); //빈즈 생성
		try {
			BeanUtils.copyProperties(beans, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MemberDAO.getInstance().insert(beans);
		response.sendRedirect("member/selectMemberList.jsp");
	}
}
