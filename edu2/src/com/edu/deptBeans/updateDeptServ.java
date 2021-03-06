package com.edu.deptBeans;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

/**
 * Servlet implementation class updateDeptServ
 */
@WebServlet("/dept/updateDept")
public class updateDeptServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//단건조회
		String department_id = request.getParameter("department_id");
		DeptBeans beans = DeptDAO.getInstance().getDept(department_id);
		request.setAttribute("beans", beans);
		request.getRequestDispatcher("updateDept.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		DeptBeans beans = new DeptBeans();
		try {
			BeanUtils.copyProperties(beans, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DeptDAO.getInstance().deptUpdate(beans);
		response.sendRedirect("SelectDept");
	}

}
