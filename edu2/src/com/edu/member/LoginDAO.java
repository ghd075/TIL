package com.edu.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.edu.common.ConnectionManager;

public class LoginDAO {
	
	// 등록
	Connection conn = null;
	PreparedStatement psmt;
	ResultSet rs = null;
	
	//싱글톤 : static 필드
	static LoginDAO instance;
	public static LoginDAO getInstance() {
		if(instance==null)
			instance=new LoginDAO();
			return instance;		
	}
	
	public boolean loginCheck(String id, String pw) {
		boolean result= false;
		try {
			conn=ConnectionManager.getConnnect();
			String sql="select username from member where userid=?"
					+ "and userpw=? ";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs=psmt.executeQuery();
			if(rs.next()) {
				result=true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.close(conn);
		}
		
		return result;
	}	
	
}
