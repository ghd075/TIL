package com.jogiyo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jogiyo.vo.MemberDTO;
import com.web.common.DAO;

public class memberDAO extends DAO{
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 싱글톤 : static 필드
	static memberDAO instance;

	public static memberDAO getInstance() {
		if (instance == null)
			instance = new memberDAO();
		return instance;
	}
	
	//등록
	public int insert(MemberDTO dto) {
		int r = 0;
		int user_code = 0;
		try {
			//1. DB연결
			connect();
			//트랜잭션 처리
			conn.setAutoCommit(false);
			//2. sql구문 준비(삽입)
			String sql = "select max(user_code) from members";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next())
				user_code = rs.getInt(1);
			user_code++;
			sql = "insert into members (user_code, id, user_name, password, "
					+ "phone, address, r_date) values (?,?,?,?,?,?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			//3. 실행
			pstmt.setInt(1, user_code);
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getUser_name());
			pstmt.setString(4, dto.getPassword());
			pstmt.setString(5, dto.getPhone());
			pstmt.setString(6, dto.getAddress());
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
	//수정
	public int update(MemberDTO dto) {
		int r = 0;
		
		try {
			//1. DB연결
			connect();
			//2. sql구문 준비(수정)
			String sql = "update members set id = ?, "
					+ "password = ?, phone = ?, address = ? where id = ?";
			pstmt = conn.prepareStatement(sql);
			//3. 실행
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getPhone());
			pstmt.setString(4, dto.getAddress());
			pstmt.setString(5, dto.getId());
			r = pstmt.executeUpdate();
			//4. 결과처리
			System.out.println(r + " 건이 수정됨");
		}catch (SQLException e) {
			System.out.println("수정실패");
			e.printStackTrace();
		}finally {
			//5. 연결해제
			disconnect();
		}
		return r;
	}
	//삭제
	public int delete(String id, String pw) {
		int result = -1;
		String dbPW = ""; //db에서 꺼낸 비밀번호를 담을 변수 
		try {
			//1. DB연결
			connect();
			//2.비밀번호조회 sql문 조회
			String sql1 = "select password from members where id = ?";			
			//2.삭제sql문 준비
			String sql2 = "delete members where id = ?";
			//트랜잭션 처리
			conn.setAutoCommit(false);
			//3. 실행(아이디에 해당하는 비밀번호를 조회한다.)
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dbPW = rs.getString("password");
				if(dbPW.equals(pw)) { //입력된 비밀번호와 DB비번 비교
					//같을 경우 회원삭제 진행
					pstmt = conn.prepareStatement(sql2);
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					conn.commit();
					result = 1; //삭제 성공
				}else {
					result = 0; //비밀번호 비교결과 다르면 0으로 리턴
				}
			}
			//4. 결과처리
			System.out.println(result + " 건이 삭제됨");
		}catch (SQLException e) {
			System.out.println("삭제실패");
			e.printStackTrace();
		}finally {
			//5. 연결해제
			disconnect();
		}
		return result;
	}
	//단건조회
	public MemberDTO selectOne(MemberDTO dto) {
		MemberDTO member = new MemberDTO();
		try {
			connect();
			String sql = "select * from members where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member.setUser_code(rs.getInt("user_code"));
				member.setId(rs.getString("id"));
				member.setUser_name(rs.getString("user_name"));
				member.setPassword(rs.getString("password"));
				member.setPhone(rs.getString("phone"));
				member.setAddress(rs.getString("address"));
				member.setR_date(rs.getDate("r_date"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//연결해제
			disconnect();
		}
		return member;
	}
	
	/**
	 * 아이디를 이용해 현재 회원정보를 가져온다.
	 * @param id 회원 아이디
	 * @return MemberBean
	 */
	public MemberDTO getUserInfo(String id) {
		MemberDTO member = new MemberDTO();
		try {
			connect();
			String sql = "select * from members where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member.setUser_code(rs.getInt("user_code"));
				member.setId(rs.getString("id"));
				member.setUser_name(rs.getString("user_name"));
				member.setPassword(rs.getString("password"));
				member.setPhone(rs.getString("phone"));
				member.setAddress(rs.getString("address"));
				member.setR_date(rs.getDate("r_date"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//연결해제
			disconnect();
		}
		return member;
	}
	

	// 전체조회
	public List<MemberDTO> selectAll() {
		List<MemberDTO> datas = new ArrayList<MemberDTO>();
		try {
			connect();
			String sql = "select * from member order by user_code";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberDTO member = new MemberDTO();
				member.setUser_code(rs.getInt("user_code"));
				member.setId(rs.getString("id"));
				member.setUser_name(rs.getString("user_name"));
				member.setPassword(rs.getString("password"));
				member.setPhone(rs.getString("phone"));
				member.setAddress(rs.getString("address"));
				member.setR_date(rs.getDate("r_date"));
				datas.add(member); // dto를 리스트에 추가
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 연결해제
			disconnect();
		}
		return datas;
	}
}
