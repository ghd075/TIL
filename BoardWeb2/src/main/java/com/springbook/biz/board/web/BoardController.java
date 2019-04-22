package com.springbook.biz.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.Paging;

@Controller
public class BoardController {
	
	@Autowired
	BoardService service;
	
	//수정폼
	//방법2
	@RequestMapping(value ="/boardUpdate/{seq}", method=RequestMethod.GET)
	public String boardUpdateForm(Model model,
								  @PathVariable Integer seq,
								  BoardVO vo) {
		vo.setSeq(seq); //seq 값 넘기기
		//단건조회
		model.addAttribute("board", service.getBoard(vo));
		return "boardUpdate";
	}
	
	//방법1
	/*
	 * @RequestMapping(value ="/boardUpdate", method=RequestMethod.GET) public
	 * String boardUpdateForm(Model model, BoardVO vo) { //단건조회
	 * model.addAttribute("board", service.getBoard(vo)); return "boardUpdate"; }
	 */
	
	//수정처리
	@RequestMapping(value="/boardUpdate", method=RequestMethod.POST)
	public String boardUpdate(BoardVO vo) {
		service.updateBoard(vo);
		return "redirect:boardList";
	}
	
	//목록조회
	@RequestMapping("/boardList")
	//public String boardList(Model model, BoardVO vo, Paging paging) {
	public String boardList(Model model, Paging paging, 
							@RequestParam(value="searchCondition", 
										  defaultValue="TITLE", 
										  required=false) String condition,
							@RequestParam(value="searchKeyword", 
										  required=false) String keyword) {
							//방법1
							//@RequestParam(value="searchKeyword", defaultValue="", required=false) String searchKeyword) {
		/*
		 * ArrayList<String> list = new ArrayList<String>(); list.add("사과");
		 * list.add("바나나");
		 */
		BoardVO vo = new BoardVO();
		vo.setSearchCondition(condition);
		vo.setSearchKeyword(keyword);
		
		//페이징 처리
		//전체건수
		paging.setTotalRecord(service.getBoardCount(vo));
		
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
