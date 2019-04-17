package com.jogiyo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jogiyo.dao.HjhDAO;
import com.jogiyo.vo.HjhDTO;
import com.web.common.Paging;




public class BoardListController2  implements Controller {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이지 버튼에서 받아오는 값 처리 부분(페이징기능)
				Paging paging = new Paging();
				ArrayList<HjhDTO> list = null;
				try {	
					//jsp의 loc_code값을 변수선언한다
					String loc_code = request.getParameter("loc_code");
					String sp = request.getParameter("p");
					int p = 1;
					if(sp != null && ! sp.isEmpty()){
						p = Integer.parseInt(sp);
					}
				
				//페이징DTO에 값을 설정
				paging.setPage(p); // 현재페이지
				paging.setPageUnit(2);
				paging.setPageSize(3); 
				
				//페이징DTO에 DAO에서 받아온 전체건수를 담는다.
				paging.setTotalRecord(HjhDAO.getInstance().count_l(loc_code));
				
				//필요한 변수를 먼저 적고
				int first = paging.getFirst();
				int last = paging.getLast();
				
				// HjhDAO에서 넘어오는 변수들을 리스트에 담는다.
				list = HjhDAO.getInstance().boardList_l(first, last, loc_code);
				
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
				
				//DAO에서 넘오원 값들을 여기에 담는다.
				request.setAttribute("paging", paging);
				request.setAttribute("list", list);
				//HttpUtil.forward(request, response, "/result/memberListOutput.jsp");
				return "/board/locationBoard.jsp";
				
				
			}
		}
