package com.jogiyo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jogiyo.dao.HjhDAO;
import com.jogiyo.vo.HjhDTO;

public class PostDeleteController2 implements Controller {

	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// jsp에서 배열값 받는 함수
		String[] board_no_d = request.getParameterValues("board_no_d"); 

		for (String n : board_no_d) {

			try {
		//dao로 하나씩 넘긴다.
			HjhDAO.getInstance().delete(Integer.parseInt(n));

			} catch (Exception e) {

				e.printStackTrace();
			}

		}

		return "redirect:PostList.do";
	}

}