package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	//BoardDAO
	/*
	 * @Autowired private BoardDAO boardDAO;
	 */
	//private Log4jAdvice log = new Log4jAdvice();
	
	//스프링을 이용한 BoardDAO
	/*
	 * @Autowired private BoardDAOSpring boardDAO;
	 */
	
	@Autowired
	private BoardDAOMybatis boardDAO;
	
	@Override
	public void insertBoard(BoardVO vo) {
		//log.printLoggin();
		//around AOP 트랜잭션 처리 시작
		boardDAO.insertBoard(vo);
		//commit
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		//log.printLoggin();
		return boardDAO.getBoardList(vo);
	}

}
