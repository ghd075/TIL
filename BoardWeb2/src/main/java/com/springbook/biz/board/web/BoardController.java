package com.springbook.biz.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService service;
	
	//수정폼
	@RequestMapping("boardUpdateForm")
	public String boardUpdateForm(Model model, BoardVO vo) {
		//단건조회
		model.addAttribute("board", service.getBoard(vo));
		return "boardUpdate";
	}
	
	//수정처리
	@RequestMapping("boardUpdate")
	public String boardUpdate(BoardVO vo) {
		service.updateBoard(vo);
		return "redirect:boardList";
	}
	
	//목록조회
	@RequestMapping("/boardList")
	public String boardList(Model model, BoardVO vo) {
		/*
		 * ArrayList<String> list = new ArrayList<String>(); list.add("사과");
		 * list.add("바나나");
		 */
		model.addAttribute("list", service.getBoardList(vo));
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
	
	//삭제
	@RequestMapping("/deleteBoard")
	public String deleteBoard(BoardVO vo) {
		service.deleteBoard(vo);
		return "redirect:boardList";
	}
}
