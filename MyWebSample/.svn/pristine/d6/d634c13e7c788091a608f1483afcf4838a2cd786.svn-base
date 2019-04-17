package com.jogiyo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jogiyo.dao.RepleDAO;
import com.jogiyo.dao.memberDAO;
import com.jogiyo.vo.MemberDTO;
import com.jogiyo.vo.RepleDTO;

public class repleController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String cmt = request.getParameter("cmt");
				
		int pNo = Integer.parseInt(request.getParameter("pNo"));
		int evalScore = Integer.parseInt(request.getParameter("score"));
		int bno = Integer.parseInt(request.getParameter("bno"));
		int reSeq = Integer.parseInt(request.getParameter("reSeq"));
		int reLevel = Integer.parseInt(request.getParameter("reLevel"));
		
		
		String checkVlaue = request.getParameter("checkValue");
		String userId = request.getParameter("userId");
		String repleText = request.getParameter("repleText");
		
		RepleDTO bean = new RepleDTO();
		try {
			MemberDTO tmpDto = new MemberDTO();
			tmpDto.setId(userId);
			MemberDTO mdto = memberDAO.getInstance().selectOne(tmpDto);
			int userCode = mdto.getUser_code(); 
					
			RepleDTO lastColumn = RepleDAO.getInstance().selectLast();
			int repleNo = lastColumn.getRepleNo() + 1;

			if (cmt.equals("cmtInsert")) {
				pNo = repleNo;
			}
			
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String curTime = f.format(date);
			
			bean.setRepleNo(repleNo);
			bean.setpNo(pNo);
			bean.setReSeq(reSeq);
			bean.setReLevel(reLevel);
			bean.setRepleText(repleText);
			bean.setReDate(curTime);
			bean.setUserCode(userCode);
			bean.setBoardNo(bno);
			
			bean.setEvalScore(evalScore);
			bean.setCheckCode(checkVlaue);
			System.out.println(bean);
			int n = 0;
			if (cmt == "cmtInsert") {
				n = RepleDAO.getInstance().insert(bean);
			} else {
				n = RepleDAO.getInstance().repleyInsert(bean);
			} 
			
			if (n > 0) {
				out.print("<script>alert('입력되었습니다.');</script>");
			} else {
				out.print("<script>입력 오류 발생했습니다.</script>");
			}

		} catch(Exception e) {
			e.printStackTrace();
		}		
		response.sendRedirect("commentPost.jsp?board_no=" + bno);
		
		return null;
	}

}
