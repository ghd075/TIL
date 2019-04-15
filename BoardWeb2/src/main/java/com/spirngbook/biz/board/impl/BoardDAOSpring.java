package com.spirngbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spirngbook.biz.board.BoardVO;
@Repository
public class BoardDAOSpring {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
    // SQL 명령어들
    private final String BOARD_INSERT = "insert into board(seq, title, writer, content) values((select nvl(max(seq), 0)+1 from board),?,?,?)";
    private final String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
    private final String BOARD_DELETE = "delete board where seq=?";
    private final String BOARD_GET    = "select * from board where seq=?";
    private final String BOARD_LIST = "select * from board  order by seq desc";
    
    // 글 등록
    public void insertBoard(BoardVO vo){
        System.out.println("===> Spring JDBC로 insertBoard() 기능 처리");
        jdbcTemplate.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
    }
    
    // 글 수정
    public void updateBoard(BoardVO vo){
    	
    }
    
    // 글 삭제
    public void deleteBoard(BoardVO vo){
    	
    }
    
    // 글 상세 조회
    public BoardVO getBoard(BoardVO vo){
    	return null;
    }
    
    // 글 목록 조회
    public List<BoardVO> getBoardList(BoardVO vo){
    	 System.out.println("===> Spring JDBC로 getBoardList() 기능 처리");
    	 return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
    }
}
