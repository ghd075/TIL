package com.dev.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dev.dao.ConnectionManager;
import com.dev.dao.LoginDAO;
import com.dev.dao.MemberDAO;
import com.dev.vo.MemberVO;

public class MemberService {

	private static MemberService service = new MemberService();
	public MemberDAO dao = MemberDAO.getInstance();

	private MemberService() {
	}

	// 싱글톤
	public static MemberService getInstance() {
		return service;
	}

	// 회원등록
	public void memberInsert(MemberVO member) {
		// 트랜잭션처리
		Connection conn = ConnectionManager.getConnnect();
		try {
			conn.setAutoCommit(false);
			// member 등록
			dao.memberInsert(conn, member);
			// login 등록
			LoginDAO.getInstance().loginInsert(conn, member);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			ConnectionManager.close(conn);
		}

	}

	// 검색
	public MemberVO memberSearch(String id) {
		// 트랜잭션처리
		Connection conn = ConnectionManager.getConnnect();
		MemberVO member = null;
		try {
			conn.setAutoCommit(false);
			member = dao.memberSearch(conn, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			ConnectionManager.close(conn);
		}
		return member;
	}

	// 회원수정
	public void memberUpdate(MemberVO member) {
		// 트랜잭션처리
		Connection conn = ConnectionManager.getConnnect();
		try {
			conn.setAutoCommit(false);
			dao.memberUpdate(conn, member);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			ConnectionManager.close(conn);
		}
	}

	// 회원삭제
	public void memberDelete(String id) {
		// 트랜잭션처리
		Connection conn = ConnectionManager.getConnnect();
		try {
			conn.setAutoCommit(false);
			// member 삭제
			dao.memberDelete(conn, id);
			// login 삭제
			LoginDAO.getInstance().loginDelete(conn, id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			ConnectionManager.close(conn);
		}
	}

	// 회원조회
	public ArrayList<MemberVO> memberList() {
		ArrayList<MemberVO> list = null;
		// 트랜잭션처리
		Connection conn = ConnectionManager.getConnnect();
		try {
			list = dao.memberList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}
		return list;
	}
}
