package com.edu.member;

import java.sql.*;

import com.edu.common.ConnectionManager;

public class LoginDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 싱글톤 : static 필드
	static LoginDAO instance;

	public static LoginDAO getInstance() {
		if (instance == null)
			instance = new LoginDAO();
		return instance;
	}
	
	public boolean loginCheck(String id, String pw) {
		boolean result = false;
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "select username from member where userid=? and userpw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.close(conn);
		}
		return result;
	}
	
}
