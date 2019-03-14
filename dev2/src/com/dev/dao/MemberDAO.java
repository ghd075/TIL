package com.dev.dao;

import java.sql.*;
import java.util.ArrayList;

import com.dev.vo.MemberVO;

public class MemberDAO {

	private static MemberDAO dao = new MemberDAO();

	private MemberDAO() {
	}

	// 싱글톤
	public static MemberDAO getInstance() {
		return dao;
	}

	// 삽입
	public void memberInsert(Connection conn, MemberVO member) throws SQLException {
		PreparedStatement pstmt = null;
		pstmt = conn.prepareStatement("insert into member values(?,?,?,?)");
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPasswd());
		pstmt.setString(3, member.getName());
		pstmt.setString(4, member.getMail());
		pstmt.executeUpdate();
	}
	
	//검색
	public MemberVO memberSearch(Connection conn, String id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberVO member = null;
		pstmt = conn.prepareStatement("select * from member where id=?");
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			member = new MemberVO();
			member.setId(rs.getString(1));
			member.setPasswd(rs.getString(2));
			member.setName(rs.getString(3));
			member.setMail(rs.getString(4));
		}
		return member;
	}

	//수정
	public void memberUpdate(Connection conn, MemberVO member) throws SQLException {
		PreparedStatement pstmt = null;
		pstmt = conn.prepareStatement("update member set passwd=?,name=?,mail=? where id=?");
		pstmt.setString(1, member.getPasswd());
		pstmt.setString(2, member.getName());
		pstmt.setString(3, member.getMail());
		pstmt.setString(4, member.getId());
		pstmt.executeUpdate();
	}

	//삭제
	public void memberDelete(Connection conn, String id) throws SQLException {
		PreparedStatement pstmt = null;

		pstmt = conn.prepareStatement("delete from member where id=?");
		pstmt.setString(1, id);
		pstmt.executeUpdate();
	}

	//조회
	public ArrayList<MemberVO> memberList(Connection conn) throws SQLException {

		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		MemberVO member = null;
		pstmt = conn.prepareStatement("select * from member order by id");
		rs = pstmt.executeQuery();
		while (rs.next()) {
			member = new MemberVO();
			member.setId(rs.getString(1));
			member.setPasswd(rs.getString(2));
			member.setName(rs.getString(3));
			member.setMail(rs.getString(4));
			list.add(member);
		}
		return list;
	}

}
