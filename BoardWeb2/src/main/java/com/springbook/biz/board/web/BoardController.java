package com.springbook.biz.board.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.Paging;

@Controller
@SessionAttributes("board")
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@ModelAttribute("condMap")
	public Map<String, String> searchConditionMap()
	{
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		conditionMap.put("작성자", "WRITER");
		return conditionMap;
	}
	
	//수정폼
	//방법2
	@RequestMapping(value ="/boardUpdate/{seq}", method=RequestMethod.GET)
	public String boardUpdateForm(Model model,
								  @PathVariable Integer seq,
								  BoardVO vo) {
		vo.setSeq(seq); //seq 값 넘기기
		//단건조회
		model.addAttribute("board", service.getBoard(vo));
		//컨트롤러 메소드가 생성하는 모델 정보 중에서 @SessionAttributes에 지정한 이름과
		//동일한 이름이 있다면 이를 세션에 저장해준다.
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
	public String boardUpdate(@ModelAttribute("board") BoardVO vo
							  ,SessionStatus st) {
		System.out.println("===update 파라미터 확인===\n"+vo);
		service.updateBoard(vo);
		st.setComplete(); //@SessionAttributes로 지정한 세션 속성을 지운다.
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
