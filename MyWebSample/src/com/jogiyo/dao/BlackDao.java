package com.jogiyo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jogiyo.vo.BlackDto;
import com.jogiyo.vo.MemberDTO;
import com.jogiyo.vo.NoticeDto;
import com.web.common.DAO;

public class BlackDao extends DAO{
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//싱글톤
	static BlackDao instance = new BlackDao();
	public static BlackDao getInstance() {
		return instance;	
	}
	
	//단건조회
	public BlackDto getId(String userid) {
		BlackDto bl = null;
		try {
			connect();
			String sql ="select userid from black where userid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				bl = new BlackDto();
				bl.setUserid(rs.getString("userid"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			//5. 연결해제 
			disconnect();
		}  
		return bl;
	}
	//삽입
	public int insert(BlackDto dto) {
		int r = 0;
		try {
			connect(); 		
			String sql="insert into black (userid) "
					+ "values(?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());
			r = pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("입력오류발생" + e.getMessage());
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return r;
	}
	
	public int delete(BlackDto dto) {
		int n = 0;
		try {
				connect();
				String sql = " delete from black "
						+	 " where userid= ? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getUserid());
				n = pstmt.executeUpdate();
				System.out.println(dto+"n건삭제");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return n;
	}
}
