package com.spirngbook.biz.board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spirngbook.biz.board.impl.BoardDAOSpring;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class BoardClientJunit {
	
	@Autowired
	BoardDAOSpring dao;
	
	@Test
	public void test() {
		BoardVO vo = new BoardVO();
		vo.setSeq(1);
		assertEquals(dao.getBoard(vo).getWriter(), "관리자");
//		fail("Not yet implemented");
	}
}
