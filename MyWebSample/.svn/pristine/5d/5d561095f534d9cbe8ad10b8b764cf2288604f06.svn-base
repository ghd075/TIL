package com.jogiyo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jogiyo.vo.MemberDTO;
import com.web.common.DAO;

public class LoginDAO extends DAO {
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	//싱글톤 : static 필드
	static LoginDAO instance;
	public static LoginDAO getInstance() {
		if(instance==null)
			instance=new LoginDAO();
			return instance;		
	}
	
	//로그인시 아이디, 비밀번호 체크 메서드
	public int loginCheck(String id, String pw) {
		int result= -1;
		String dbPW = ""; //db에서 꺼낸 비밀번호를 담을 변수
		try {
			connect();
			String sql="select password from members where id=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			if(rs.next()) {
				dbPW = rs.getString("password"); 
				if(dbPW.equals(pw)) {
					result = 1; //넘겨받은 비번과 꺼내온 비번 비교, 같으면 인증 성공
				}else {
					result = 0; //DB의 비밀번호와 입력받은 비밀번호 다름, 인증실패
				}
			}else {
				result = -1; //해당 아이디가 없을 경우
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return result;
	}
	
	//아이디 중복체크를 하는 메서드
	public MemberDTO duplicateIdCheck(String id) {
		MemberDTO member = new MemberDTO();
		try {
			connect();
			String sql="select id from members where id=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs=psmt.executeQuery();
			if(rs.next()) {
				member.setId(rs.getString("id"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		
		return member;
	}
	
}
