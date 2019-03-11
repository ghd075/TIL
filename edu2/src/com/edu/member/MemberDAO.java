package com.edu.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.common.ConnectionManager;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 싱글톤 : static 필드
	static MemberDAO instance;

	public static MemberDAO getInstance() {
		if (instance == null)
			instance = new MemberDAO();
		return instance;
	}
	
	//등록
	public int insert(MemberDTO dto) {
		int r = 0;
		try {
			//1. DB연결
			conn = ConnectionManager.getConnnect();
			//트랜잭션 처리
			conn.setAutoCommit(false);
			//2. sql구문 준비(삽입)
			String sql = "insert into member (userid, userpw, username, "
					+ "gender, regdate) values (?,?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			//3. 실행
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getUserpw());
			pstmt.setString(3, dto.getUserpw());
			pstmt.setString(4, dto.getGender());
			r = pstmt.executeUpdate();
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
			ConnectionManager.close(conn);
		}
		return r;
	}
	//수정
	public int update(MemberDTO dto) {
		int r = 0;
		
		try {
			//1. DB연결
			conn = ConnectionManager.getConnnect();
			//2. sql구문 준비(수정)
			String sql = "update member set job = ?, hobby = ?, "
					+ "info = ? where userid = ?";
			pstmt = conn.prepareStatement(sql);
			//3. 실행
			pstmt.setString(1, dto.getJob());
			pstmt.setString(2, dto.getHobby());
			pstmt.setString(3, dto.getInfo());
			pstmt.setString(4, dto.getUserid());
			r = pstmt.executeUpdate();
			//4. 결과처리
			System.out.println(r + " 건이 수정됨");
		}catch (SQLException e) {
			System.out.println("등록실패");
			e.printStackTrace();
		}finally {
			//5. 연결해제
			ConnectionManager.close(conn);
		}
		return r;
	}
	//삭제
	public int delete(MemberDTO dto) {
		int r = 0;
		
		try {
			//1. DB연결
			conn = ConnectionManager.getConnnect();
			//2. sql구문 준비(삭제)
			String sql = "delete member where userid = ?";
			pstmt = conn.prepareStatement(sql);
			//3. 실행
			pstmt.setString(1, dto.getUserid());
			r = pstmt.executeUpdate();
			//4. 결과처리
			System.out.println(r + " 건이 삭제됨");
		}catch (SQLException e) {
			System.out.println("등록실패");
			e.printStackTrace();
		}finally {
			//5. 연결해제
			ConnectionManager.close(conn);
		}
		return r;
	}
	//단건조회
	public MemberDTO selectOne(MemberDTO dto) {
		MemberDTO member = new MemberDTO();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "select * from member where userid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member.setUserid(rs.getString("userid"));
				member.setUserpw(rs.getString("userpw"));
				member.setUsername(rs.getString("username"));
				member.setJob(rs.getString("job"));
				member.setHobby(rs.getString("hobby"));
				member.setInfo(rs.getString("info"));
				member.setGender(rs.getString("gender"));
				member.setRegdate(rs.getDate("regdate"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//연결해제
			ConnectionManager.close(conn);
		}
		return member;
	}

	// 전체조회
	public List<MemberDTO> selectAll() {
		List<MemberDTO> datas = new ArrayList<MemberDTO>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "select * from member order by userid";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberDTO member = new MemberDTO();
				member.setUserid(rs.getString("userid"));
				member.setUserpw(rs.getString("userpw"));
				member.setUsername(rs.getString("username"));
				member.setJob(rs.getString("job"));
				member.setHobby(rs.getString("hobby"));
				member.setInfo(rs.getString("info"));
				member.setGender(rs.getString("gender"));
				member.setRegdate(rs.getDate("regdate"));
				datas.add(member); // dto를 리스트에 추가
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 연결해제
			ConnectionManager.close(conn);
		}
		return datas;
	}
}
