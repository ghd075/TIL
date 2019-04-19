package com.spirngbook.biz.board;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
//import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

//import com.spirngbook.biz.board.impl.BoardDAOSpring;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:config/applicationContext.xml",
								  "classpath:config/context-mapper.xml"})
public class BoardClientJunit {
	
	@Autowired
	BoardService service;
	
	//static BoardVO vo;
	BoardVO vo;
	
	//최초 한 번만 실행할 수 있도록 설정
//	@BeforeClass
	@Before
	public void init() {
		vo = new BoardVO();
	}
	/*
	 * public static void init() { vo = new BoardVO(); }
	 */
	
	//목록수정
	@Test
	public void updateTest() {
		vo.setSeq(1);
		vo.setCnt(10);
		service.updateBoard(vo);
	}
	
	//목록조회
	@Test
	public void getBoardList() {
		
		vo.setSearchCondition("TITLE"); 
		vo.setSearchKeyword("가입인사");
		 
		List<BoardVO> list = service.getBoardList(vo);
		for(BoardVO board : list) {
			System.out.println(board);
		}
	}
	
	//@Test
	@Ignore
	public void insertTest() {
		vo.setSeq(19);
		vo.setTitle("트랜잭션");
		vo.setWriter("이순신");
		vo.setContent("트랜잭션 테스트");
		service.insertBoard(vo);
	}
	
	@Ignore //해당 메소드 무시
	//@Test
	public void test() {
		vo.setSeq(1);
		assertEquals(service.getBoard(vo).getWriter(), "관리자");
//		fail("Not yet implemented");
	}
	
	@Ignore //해당 메소드 무시
	//@Test
	public void deleteTest() {
		vo.setSeq(8);
		service.deleteBoard(vo);
	}
}
