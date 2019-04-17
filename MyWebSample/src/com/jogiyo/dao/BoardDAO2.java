package com.jogiyo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.jogiyo.vo.BoardDTO;
import com.web.common.DAO;

public class BoardDAO2  extends DAO {
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	// 싱글톤 : static 필드
	static BoardDAO2 instance;
	
	public static BoardDAO2 getInstance() {
		if (instance == null)
			instance = new BoardDAO2();
		return instance;
	}
	
	public List<HashMap<String, Object>> selectOne(BoardDTO bean) throws Exception {
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		try {
			
			connect();
			stmt = conn.createStatement();
		
			String sql = "SELECT "
					+ "b.board_no, "
					+ "b.title, "
					+ "b.board_text, "
					+ "b.images, "
					+ "b.cnt, "
					+ "to_char(b.b_date, 'yyyy-mm-dd hh24:mi:ss') as b_date, "
					+ "b.user_code, "
					+ "m.id, "
					+ "b.food_code, "
					+ "b.loc_code "
					+ "FROM board b left join members m on b.user_code = m.user_code "
					+ "where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getBoard_no());			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("boardNo", rs.getString("board_no"));
				map.put("title", rs.getString("title"));
				map.put("boardText", rs.getString("board_text"));
				map.put("images", rs.getString("images"));
				map.put("cnt", rs.getString("cnt"));
				map.put("bDate", rs.getString("b_date"));
				map.put("userCode", rs.getString("user_code"));
				map.put("userId", rs.getString("id"));
				map.put("foodCode", rs.getString("food_code"));
				map.put("locCode", rs.getString("loc_code"));

				list.add(map);
			}		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return list;
	}
	
	public int cntUpdate(BoardDTO bean) throws Exception {
		int n = 0;
		PreparedStatement pstmtCommentInsert = null;
		try {
			connect();
			conn.setAutoCommit(false);   //트랜잭션 처리
			String sql ="update board set cnt = cnt + 1 where board_no = ?";
			pstmtCommentInsert = conn.prepareStatement(sql);
			pstmtCommentInsert.setInt(1, bean.getBoard_no());			
			pstmtCommentInsert.executeUpdate();
			conn.commit();   // 커밋
			n = 1;
		} catch (Throwable e) {
			try {
				System.out.println("cnt update error!");
				conn.rollback();  //롤백
			} catch (SQLException ex) {
			}
			throw new Exception(e.getMessage());
		} finally {
			conn.close();
		}
		return n;
	}
	
	public int update(BoardDTO bean) throws Exception {
		int n = 0;
		PreparedStatement pstmtCommentInsert = null;
		try {
			connect();
			conn.setAutoCommit(false);   //트랜잭션 처리
 
			String sql ="update board set title=?,"
					+ " board_text=?, food_code=?,"
					+ " loc_code=?, b_date=to_date(?,'yyyy-mm-dd hh24:mi:ss')"
					+ " where board_no = ?";
			pstmtCommentInsert = conn.prepareStatement(sql);
			pstmtCommentInsert.setString(1, bean.getTitle());			
			pstmtCommentInsert.setString(2, bean.getBoard_text());
			pstmtCommentInsert.setString(3, bean.getFood_code());
			pstmtCommentInsert.setString(4, bean.getLoc_code());
			pstmtCommentInsert.setString(5, bean.getBoard_date());
			pstmtCommentInsert.setInt(6, bean.getBoard_no());
			pstmtCommentInsert.executeUpdate();
			conn.commit();   // 커밋
			n = 1;
		} catch (Throwable e) {
			try {
				System.out.println("board update error!");
				conn.rollback();  //롤백
			} catch (SQLException ex) {
			}
			throw new Exception(e.getMessage());
		} finally {
			conn.close();
		}
		return n;
	}
	
	public int delete(BoardDTO bean) throws Exception {
		int n = 0;
		PreparedStatement pstmtDeleteReple = null;
		PreparedStatement pstmtDeleteBoard = null;
		PreparedStatement pstmtDeleteLikes = null;
		try {
			connect();
			conn.setAutoCommit(false);   //트랜잭션 처리
 
			String sql1 ="delete from reples where board_no = ?";
			pstmtDeleteReple = conn.prepareStatement(sql1);
			pstmtDeleteReple.setInt(1, bean.getBoard_no());			
			pstmtDeleteReple.executeUpdate();

			String sql2 ="delete from likes where board_no = ?";
			pstmtDeleteLikes = conn.prepareStatement(sql2);
			pstmtDeleteLikes.setInt(1, bean.getBoard_no());			
			pstmtDeleteLikes.executeUpdate();
			
			String sql3 ="delete from board where board_no = ?";
			pstmtDeleteBoard = conn.prepareStatement(sql3);
			pstmtDeleteBoard.setInt(1, bean.getBoard_no());			
			pstmtDeleteBoard.executeUpdate();			
			conn.commit();   // 커밋
			n = 1;
		} catch (Throwable e) {
			try {
				System.out.println("board delete error!");
				conn.rollback();  //롤백
			} catch (SQLException ex) {
			}
			throw new Exception(e.getMessage());
		} finally {
			conn.close();
		}
		return n;
	}	
}
