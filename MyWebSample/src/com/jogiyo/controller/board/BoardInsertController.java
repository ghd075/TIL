package com.jogiyo.controller.board;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jogiyo.controller.Controller;
import com.jogiyo.dao.BoardDAO;
import com.jogiyo.vo.BoardDTO;

public class BoardInsertController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Parameter 추출
		String title = request.getParameter("title");
		String board_text = request.getParameter("contents");
		String food_code = request.getParameter("food_code");
		String loc_code = request.getParameter("loc_code");
//		String images = request.getParameter("attachFile"); //이미지값 추출
		String images = ""; //이미지값 추출
		Pattern pattern = Pattern.compile("<img[^>]*src=[\"']?([^>\"']+)[\"']?[^>]*>");
		Matcher matcher = pattern.matcher(board_text);
		//System.out.println(board_text);
		while(matcher.find()) {
			String data = matcher.group(1);
			//System.out.println(data.substring(data.lastIndexOf("/")+1));
			images = data.substring(data.lastIndexOf("/")+1);
		}
		BoardDTO board = new BoardDTO();
		//세션이 가지고 있는 유저코드 값을 가져온다.
		HttpSession session = request.getSession();
		String user_code = session.getAttribute("sessionUser_code").toString();
		// 입력된 정보를 DTO에 세팅한다.
		board.setTitle(title);
		board.setBoard_text(board_text);
		board.setFood_code(food_code);
		board.setUser_code(Integer.parseInt(user_code));
		board.setLoc_code(loc_code);
		board.setImages(images);
		
		BoardDAO.getInstance().insert(board);
		
		// 메인 페이지로 이동
		return "redirect:../main/MianForm.do";
	}
}
