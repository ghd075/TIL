package com.dev.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dev.service.DeptService;
import com.dev.service.MemberService;
import com.dev.vo.DeptBeans;

public class DeptDeleteController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 파라미터 받고
		String department_id = request.getParameter("department_id");
		// 서비스(db처리)
		DeptService.getInstance().deptDelete(department_id);
		// Output View 페이지로 이동
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<script>alert('부서 정보 삭제가 완료되었습니다.!!');");
		out.print("location='deptList.do';");
		out.print("</script>");
		return null;
	}

}
