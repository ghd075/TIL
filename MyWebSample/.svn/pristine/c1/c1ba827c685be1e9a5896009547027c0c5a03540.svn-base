package com.jogiyo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jogiyo.dao.HjhDAO;
import com.jogiyo.vo.HjhDTO;

public class BestListController implements Controller {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<HjhDTO> list = null;
		
		try {
			list = HjhDAO.getInstance().bestList();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//dao에서 받은 값(list)을 "list"로 담아서 jsp로 돌려준다.
		request.setAttribute("list", list);
		return "/board/bestmenuBoard.jsp";
	}

}
