package com.springbook.biz.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
@Repository
public class BoardDAOMybatis {
	@Autowired
	SqlSessionTemplate mybatis;
	
	public void insertBoard(BoardVO vo) {
		//System.out.println("===> Mybatis로 insertBoard() 기능 처리");
		//mybatis.insert("BoardDAO.insertBoard",vo);
		System.out.println("===> Mybatis로 insertBoard() 기능(procedure) 처리");
		mybatis.insert("BoardDAO.insertBoardProcedure",vo);
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 updateBoard() 기능 처리");
		mybatis.update("BoardDAO.updateBoard",vo);
	}
	
	public void deleteBoard(BoardVO vo) {
		 System.out.println("===> Mybatis로 deleteBoard() 기능 처리");
		 mybatis.delete("BoardDAO.deleteBoard",vo);
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 getBoard() 기능 처리");
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Mybatis로 getBoardList() 기능 처리");
		return mybatis.selectList("BoardDAO.getBoardList", vo);
	}
	
	public Integer getBoardCount(BoardVO vo) {
		System.out.println("===> Mybatis로 getBoardCount() 기능 처리");
		return mybatis.selectOne("BoardDAO.getBoardCount", vo);
	}
}
