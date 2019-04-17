package com.jogiyo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jogiyo.vo.BoardDTO;
import com.web.common.DAO;

public class BoardDAO extends DAO {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 싱글톤 : static 필드
	static BoardDAO instance;

	public static BoardDAO getInstance() {
		if (instance == null)
			instance = new BoardDAO();
		return instance;
	}

	//등록
	public int insert(BoardDTO dto) {
		int r = 0;
		int user_code = 0;
		try {
			//1. DB연결
			connect();
			//트랜잭션 처리
			conn.setAutoCommit(false);
			//2. sql구문 준비(삽입)
			String sql = "select max(board_no) from board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next())
				user_code = rs.getInt(1);
			user_code++;
			sql = "insert into board (board_no, title, board_text, images, "
					+ "cnt, b_date, user_code, food_code, loc_code) values (?,?,?,?,0,sysdate,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			//3. 실행
			pstmt.setInt(1, user_code);
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getBoard_text());
			pstmt.setString(4, dto.getImages());
			pstmt.setInt(5, dto.getUser_code());
			pstmt.setString(6, dto.getFood_code());
			pstmt.setString(7, dto.getLoc_code());
			//System.out.println(dto);
			r = pstmt.executeUpdate();
			if (r != 1 ) 
				user_code = 0;
			conn.commit();
			//4. 결과처리
			System.out.println(r + " 건이 등록됨");
		}catch (SQLException e) {
			System.out.println("등록실패");
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			//5. 연결해제
			disconnect();
		}
		return r;
	}
}
