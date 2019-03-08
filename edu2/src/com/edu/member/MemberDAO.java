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
	PreparedStatement psmt;
	ResultSet rs =null;
	//싱글톤
	static MemberDAO instance;
	public static MemberDAO getInstance() {
		if(instance==null) 
			instance=new MemberDAO();			
			return instance;
	}
	//삽입
	public int insert(MemberDTO dto) {
		int r=0;
		try {
			conn=ConnectionManager.getConnnect();
			conn.setAutoCommit(false);
			String sql="insert into members(userid, userpw,"
					+ "username, job, hobby, info, gender, regdate)"
					+ "values(?,?,?,?,?,?,?,sysdate) ";
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getUserid());
			psmt.setString(2, dto.getUserpw());
			psmt.setString(3, dto.getUsername());
			psmt.setString(4, dto.getJob());
			psmt.setString(5, dto.getHobby());
			psmt.setString(6, dto.getInfo());
			psmt.setString(7, dto.getGender());
			//psmt.setString(8, dto.getRegdate());
			
			r=psmt.executeUpdate();
			conn.commit();
			System.out.println(r+"건이 등록됨");
		}catch (Exception e) {
			e.printStackTrace();
			try{
				conn.rollback();
			}catch (SQLException e1) {
				// TODO: handle exception
			}
		}finally {
			ConnectionManager.close(conn);
			return r;
		}
		
	}
	//수정
	public int update(MemberDTO dto) {
		int r=0;
		try {
			conn=ConnectionManager.getConnnect();
			conn.setAutoCommit(false);
			String sql="update members set "
					+ "userid=?, userpw=?, username=?, "
					+ "job=?, hobby=?, info=?, gender=?, regdate=?"
					+ "where userid=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getUserid());
			psmt.setString(2, dto.getUserpw());
			psmt.setString(3, dto.getUsername());
			psmt.setString(4, dto.getJob());
			psmt.setString(5, dto.getHobby());
			psmt.setString(6, dto.getInfo());
			psmt.setString(7, dto.getGender());
			psmt.setString(8, dto.getRegdate());
			
			r=psmt.executeUpdate();
			conn.commit();
			System.out.println(r+"건이 등록됨");
		}catch (Exception e) {
			e.printStackTrace();
			try{
				conn.rollback();
			}catch (SQLException e1) {
				// TODO: handle exception
			}
		}finally {
			ConnectionManager.close(conn);
			return r;
		}
		
	}
	//삭제
	public int delete(MemberDTO dto) {
		int r=0;
		try {
			conn=ConnectionManager.getConnnect();
			conn.setAutoCommit(false);
			String sql="delete members where userid=? ";
			PreparedStatement psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, dto.getUserid());
			
			r=psmt.executeUpdate();
			conn.commit();
			System.out.println(r+"건이 등록됨");
		}catch (Exception e) {
			e.printStackTrace();
			try{
				conn.rollback();
			}catch (SQLException e1) {
				// TODO: handle exception
			}
		}finally {
			ConnectionManager.close(conn);
			return r;
		}
		
	}
	//단건조회
	public MemberDTO selectOne(MemberDTO dto) {
		MemberDTO member = new MemberDTO();
		try {
			conn=ConnectionManager.getConnnect();
			String sql="select * from members where userid=? ";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dto.getUserid());
			rs=psmt.executeQuery();
			if(rs.next()) {
				member.setUserid(rs.getString("userid"));
				member.setUserpw(rs.getString("userpw"));
				member.setUsername(rs.getString("username"));
				member.setJob(rs.getString("job"));
				member.setHobby(rs.getString("hobby"));
				member.setInfo(rs.getString("info"));
				member.setGender(rs.getString("gender"));
				member.setRegdate(rs.getString("regdate"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.close(rs,psmt,conn);
		}
		return member;		
	}		
	
	//전체 조회
	public List<MemberDTO> selectAll(){
		List<MemberDTO> datas = new ArrayList<MemberDTO>();
		try {
			String sql= "select * from members order by userid ";
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()) {
				MemberDTO member = new MemberDTO();
				member.setUserid(rs.getString("userid"));
				member.setUserpw(rs.getString("userpw"));
				member.setUsername(rs.getString("username"));
				member.setJob(rs.getString("job"));
				member.setHobby(rs.getString("hobby"));
				member.setInfo(rs.getString("info"));
				member.setGender(rs.getString("gender"));
				member.setRegdate(rs.getString("regdate"));
				datas.add(member);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.close(conn);
		}		
		return datas;
	}	
	
}
