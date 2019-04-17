package com.jogiyo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jogiyo.dao.HjhDAO;
import com.jogiyo.vo.HjhDTO;


public class MemberDeleteController2 implements Controller {

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String[] user_code_d = request.getParameterValues("user_code_d"); //배열값 받는 함수
		
		for(String n : user_code_d) {
				
						
			try {
			
				  HjhDAO.getInstance().delete_m(Integer.parseInt(n));
			
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
		
				
		return "redirect:MemberList.do";
	}

	
	}
