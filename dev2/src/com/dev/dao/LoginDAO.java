package com.dev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dev.vo.MemberVO;

public class LoginDAO {

	// 싱글톤
	private static LoginDAO dao = new LoginDAO();

	public static LoginDAO getInstance() {
		return dao;
	}

	// 삽입
	public void loginInsert(Connection conn, MemberVO member) throws SQLException {
		PreparedStatement pstmt = null;
		pstmt = conn.prepareStatement("insert into login(id, passwd) values(?,?)");
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPasswd());
		pstmt.executeUpdate();
	}

	// 삭제
	public void loginDelete(Connection conn, String id) throws SQLException {
		PreparedStatement pstmt = null;

		pstmt = conn.prepareStatement("delete from login where id=?");
		pstmt.setString(1, id);
		pstmt.executeUpdate();
	}

}
