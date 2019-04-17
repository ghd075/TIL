package com.jogiyo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jogiyo.dao.BoardDAO2;
import com.jogiyo.dao.FoodDAO;
import com.jogiyo.dao.LocationDAO;
import com.jogiyo.vo.BoardDTO;
import com.jogiyo.vo.FoodDTO;
import com.jogiyo.vo.LocationDTO;
import com.jogiyo.vo.MemberDTO;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class sampleController
 */
//@WebServlet("/repleController")
public class DisplayBoardController implements Controller {
	//private static final long serialVersionUID = 1L;
       
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
				
		//userId는 session id, 없을 경우 "" 값을 가짐
		String userId = request.getParameter("userId");
		BoardDTO bean = new BoardDTO();
		bean.setBoard_no(Integer.parseInt(request.getParameter("boardNo")));
		
		//목록
		try {
			//유저 정보 추출
		  	//MemberDTO tmpDto = new MemberDTO();
			//tmpDto.setId(userId);
			//MemberDTO mdto = memberDAO.getInstance().selectOne(tmpDto);
			BoardDAO2.getInstance().cntUpdate(bean);
			List<HashMap<String, Object>> list = BoardDAO2.getInstance().selectOne(bean);
			
			//footMap에 code와 name존재
			FoodDTO fbean = new FoodDTO();
			String foodCode = (String) list.get(0).get("foodCode");
			fbean.setFoodCode(foodCode);
			HashMap<String, Object> foodMap = FoodDAO.getInstance().selectOne(fbean);
			
			//locMap에 code와 name존재
			LocationDTO lbean = new LocationDTO();
			String locCode = (String) list.get(0).get("locCode");
			lbean.setLocCode(locCode);
			HashMap<String, Object> locMap = LocationDAO.getInstance().selectOne(lbean);
						
			list.get(0).put("foodName", foodMap.get("foodName"));
			list.get(0).put("locName", locMap.get("locName"));
			
			out.print(JSONArray.fromObject(list));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}

}
