package com.jogiyo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.jogiyo.vo.LikeDTO;
import com.jogiyo.vo.MemberDTO;
import com.jogiyo.vo.RepleDTO;
import com.web.common.DAO;

public class LikeDAO  extends DAO {
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	// 싱글톤 : static 필드
	static LikeDAO instance;
	
	public static LikeDAO getInstance() {
		if (instance == null)
			instance = new LikeDAO();
		return instance; 
		
	}
	
	public int selectCount(LikeDTO bean) throws Exception {
		int result = 0;
		try {		
			connect();
			stmt = conn.createStatement();
		
			String sql = "select count(*) cnt from likes where board_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getBoardNo());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				result = rs.getInt("cnt");
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
		return result;
	}
	
	public int selectOne(LikeDTO bean) throws Exception {
		int result = 0; 
		try {		
			connect();
			stmt = conn.createStatement();
		
			String sql = "select user_code from likes where board_no=? and user_code=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getBoardNo());
			pstmt.setInt(2, bean.getUserCode());

			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				result = rs.getInt("user_code");
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
		return result;
	}
	
	public int delete(LikeDTO bean) throws Exception {
		int n = 0;
		PreparedStatement pstmtDelete = null;
		try {
			connect();
			conn.setAutoCommit(false);   //트랜잭션 처리
			String sql ="delete from likes where board_no =? and user_code=?"; 
			pstmtDelete = conn.prepareStatement(sql);
			pstmtDelete.setInt(1, bean.getBoardNo());
			pstmtDelete.setInt(2, bean.getUserCode());
			n = pstmtDelete.executeUpdate();

			conn.commit();   // 커밋
		} catch (Throwable e) {
			try {
				conn.rollback();  //롤백
			} catch (SQLException ex) {
			}
			throw new Exception(e.getMessage());
		} finally {
			conn.close();
		}
		return n;
	}	
	
	public int insert(LikeDTO bean) {
		int n = 0;
		PreparedStatement pstmtInsert = null;
		System.out.println(bean);

		try {
			connect();
			String sql = "insert into likes (user_code, board_no) values (?,?)";
			pstmtInsert = conn.prepareStatement(sql);
			pstmtInsert.setInt(1, bean.getUserCode());
			pstmtInsert.setInt(2, bean.getBoardNo());
			n = pstmtInsert.executeUpdate();
			System.out.println("결과 : " +n);			
		} catch (SQLException e) {
			System.out.println("등록실패");
			e.printStackTrace();
			
			try {
				conn.rollback();

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			//5. 연결해제
			disconnect();
		}

		return n;
	} 
}
