package com.spirngbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient2 {

	public static void main(String[] args) {
		//1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		//2. Spring 컨테이너로부터 BoardServiceImpl 객체를 Lookup한다.
		BoardService service = (BoardService)container.getBean("boardService"); //name 검색
		//BoardService service2 = container.getBean(BoardService.class); //클래스 타입 검색
		
		//3. 글 등록 기능 테스트
		BoardVO vo = new BoardVO();
		vo.setTitle("aop around 테스트");
		vo.setWriter("홍길동");
		vo.setContent("임시 내용...");
		service.insertBoard(vo);
		
		//4. 글 목록 검색 기능 테스트
		List<BoardVO> list = service.getBoardList(null);
		for(BoardVO board : list) {
			System.out.println(board.getSeq() + " : " + board.getTitle());
		}
	}

}
