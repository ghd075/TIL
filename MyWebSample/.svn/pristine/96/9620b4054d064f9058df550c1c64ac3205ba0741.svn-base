package com.jogiyo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jogiyo.dao.LikeDAO;
import com.jogiyo.dao.memberDAO;
import com.jogiyo.vo.LikeDTO;
import com.jogiyo.vo.MemberDTO;

import net.sf.json.JSONArray;


/**
 * Servlet implementation class sampleController
 */
//@WebServlet("/repleController")
public class LikeController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		int boardNo = Integer.parseInt(request.getParameter("boardNo")); 
		String like = request.getParameter("like");
		String userId = request.getParameter("userId");

		try {
			MemberDTO tmpDto = new MemberDTO();
			tmpDto.setId(userId);
			MemberDTO mdto = memberDAO.getInstance().selectOne(tmpDto);
			int userCode = mdto.getUser_code();
			
			LikeDTO bean = new LikeDTO();
			bean.setBoardNo(boardNo);
			bean.setUserCode(userCode);
			
			if (like.equals("insert")) {
				LikeDAO.getInstance().insert(bean);
			}
			
			if (like.equals("delete")){
				LikeDAO.getInstance().delete(bean);
			}
			
			List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
			HashMap<String, Object> map = new HashMap<String, Object>();
			int uCode = 0;
			int cnt = 0;
			boolean likeCheck = false;
			uCode =  LikeDAO.getInstance().selectOne(bean);
			cnt =  LikeDAO.getInstance().selectCount(bean);
			if (uCode > 0) {
				likeCheck = true;
			} else {
				likeCheck = false;
			}
			map.put("likeCheck", likeCheck);
			map.put("cnt", cnt);
			list.add(map);
			
			out.print(JSONArray.fromObject(list));			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
