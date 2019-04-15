package com.spirngbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spirngbook.biz.board.BoardService;
import com.spirngbook.biz.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	/*
	 * @Autowired private BoardDAO boardDAO;
	 */
	//private Log4jAdvice log = new Log4jAdvice();
	
	@Autowired
	private BoardDAOSpring boardDAO;
	
	@Override
	public void insertBoard(BoardVO vo) {
		//log.printLoggin();
		boardDAO.insertBoard(vo);
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
