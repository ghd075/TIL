package com.spirngbook.biz.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spirngbook.biz.board.BoardService;
import com.spirngbook.biz.board.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService service;
	
	//목록조회
	@RequestMapping("/boardList")
	public String boardList(Model model) {
		/*
		 * ArrayList<String> list = new ArrayList<String>(); list.add("사과");
		 * list.add("바나나");
		 */
		model.addAttribute("list", service.getBoardList(null));
		return "board";
	}
	
	//등록폼
	@RequestMapping("/boardInsertForm")
	public String boardInsertForm() {
		return "boardInsert";
	}
	
	//등록처리
	@RequestMapping("/boardInsert")
	public String boardInsert(BoardVO vo) {
		service.insertBoard(vo);
		return "redirect:boardList";
	}
}
