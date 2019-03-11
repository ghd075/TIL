package com.edu.deptBeans;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

@WebServlet("/insertDept")
public class insertDeptServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//파라미터를 빈즈에 담고 (<jsp:useBean />, <jsp:setProperty />)
		DeptBeans beans = new DeptBeans(); //빈즈 생성
		try {
			request.setCharacterEncoding("UTF-8"); //post방식일 때 한글 인코딩 설정
			BeanUtils.copyProperties(beans, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DeptDAO.getInstance().deptInsert(beans);
		response.sendRedirect("dept/selectDeptList.jsp");
		//빈즈에 데이터 담기
		/*
		 * beans.setDepartment_id(request.getParameter("department_id"));
		 * beans.setDepartment_name(request.getParameter("department_name"));
		 * beans.setManager_id(request.getParameter("manager_id"));
		 * beans.setLocation_id(request.getParameter("location_id")); //DAO클래스의
		 * insert메서드 호출 DeptDAO.getInstance().deptInsert(beans); //삽입메서드 호출
		 * response.sendRedirect("selectDeptList.jsp");
		 */
	}

}
