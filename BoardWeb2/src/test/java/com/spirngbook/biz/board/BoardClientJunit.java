package com.spirngbook.biz.board;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.fail;

import org.junit.Before;
//import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//import com.spirngbook.biz.board.impl.BoardDAOSpring;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
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
	
	@Test
	public void test() {
		vo.setSeq(1);
		assertEquals(service.getBoard(vo).getWriter(), "관리자");
//		fail("Not yet implemented");
	}
	
	@Test
	public void deleteTest() {
		vo.setSeq(8);
		service.deleteBoard(vo);
	}
}
