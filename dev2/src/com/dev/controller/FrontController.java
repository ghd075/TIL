package com.dev.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class FrontController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	String charset = null; //인코딩 문자코드 지정할 변수
	HashMap<String, Controller> list = null; //컨트롤러 정보를 저장할 변수

	@Override
	public void init(ServletConfig sc) throws ServletException {

		charset = sc.getInitParameter("charset");
		
		//필요한 컨트롤러들을 리스트에 담아두기
		//('사용자가 정한 이름.do', new 해당 컨트롤러);
		list = new HashMap<String, Controller>();
		list.put("/memberInsert.do", new MemberInsertController());
		list.put("/memberSearch.do", new MemberSearchController());
		list.put("/memberUpdate.do", new MemberUpdateController());
		list.put("/memberDelete.do", new MemberDeleteController());
		list.put("/memberList.do", new MemberListController());
		list.put("/deptList.do", new DeptListController());
		list.put("/insertDept.do", new DeptInsertController());
		list.put("/updateDeptForm.do", new DeptUpdateFormController());
		list.put("/deleteDept.do", new DeptDeleteController());
		list.put("/updateDept.do", new DeptUpdateController());

	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding(charset);

		String url = request.getRequestURI();
		// uri : /dev/memberInsert.do
		String contextPath = request.getContextPath();
		// contextPath 구하기(/dev)
		String path = url.substring(contextPath.length());
		// 경로 구하기
		// /memberInsert.do

		Controller subController = list.get(path);
		//해당 컨트롤러 찾고(MemberInsertController())
		String view = subController.execute(request, response);
		//이동할 페이지를 view변수에 담는다.
		//다형성(실행결과가 다 다름)
		//참조하는 자식객체 메서드 호출
		if( view != null) { //view변수가 NULL값이 아니면
			if(view.startsWith("redirect:")) { //view변수의 데이터가 redirect:로 시작하면
				response.sendRedirect(view.substring(9)); // /dev/memberList.do페이지를 리다이렉트로 실행
			}else {
				HttpUtil.forward(request, response, view); // view에 저장될 값을 forward로 실행
			}
		}
	}
}
