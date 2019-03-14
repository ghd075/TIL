package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.DeptService;
import com.dev.vo.DeptBeans;

//수정페이지
public class DeptUpdateFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//파라미터 받고
		String department_id = request.getParameter("department_id");
		//서비스(db처리)
		DeptBeans beans = DeptService.getInstance().getDept(department_id);
		//결과를 저장
		request.setAttribute("beans", beans);
		//포워드 될 페이지명을 리턴
		return "/dept/updateDept.jsp";
	}

}
