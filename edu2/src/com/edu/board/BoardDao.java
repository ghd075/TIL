package com.edu.board;

import java.util.*;
import java.sql.*;

public class BoardDao extends DAO {

	static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	PreparedStatement pstmt;
	
	public int insert(Board bean) {
		
		int id = 0;
		try {
			connect();			
			
			String sql="select max(id) from board ";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				id = rs.getInt(1);
			id++;
			
			sql="insert into board (id, username, contents) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, bean.getUserName());
			pstmt.setString(3, bean.getContents());
			
			int result = pstmt.executeUpdate();
			if (result != 1 ) 
				id=0;
		} catch(Exception e) {
			System.out.print("입력오류 : " + e.getMessage());
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return id;
	}
	
	public boolean update(Board bean) {
		try {
			connect();		
			String sql="update board set username=?, contents=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getUserName());
			pstmt.setString(2, bean.getContents());
			pstmt.setString(3, bean.getId());
			
			int result = pstmt.executeUpdate();
			if (result != 1 ) 
				throw new Exception();
		} catch(Exception e) {
			System.out.print("수정오류 : " + e.getMessage());
			return false;
		} finally {
			disconnect();
		}
		return true;
	}
	
	public boolean delete(String id) {
		try {
			connect();		
			String sql="delete board where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			int result = pstmt.executeUpdate();
			if (result != 1 ) 
				throw new Exception();
		} catch(Exception e) {
			System.out.print("삭제오류 : " + e.getMessage());
			return false;
		} finally {
			disconnect();
		}
		return true;
	}
	
	public Board select(String id) {
		Board bean = null;
		try {
			connect();		
			String sql="select * from board where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next() ) {
				bean = new Board();
				bean.setId(rs.getString("id"));
				bean.setUserName(rs.getString("username"));
				bean.setContents(rs.getString("contents"));
			}
		} catch(Exception e) {
			System.out.print("조회 오류 : " + e.getMessage());
		} finally {
			disconnect();
		}
		return bean;
	}
	
	public ArrayList<Board> selectAll() {
		ArrayList<Board> datas = new ArrayList<Board>();
		Board bean = null;
		try {
			connect();		
			String sql="select * from board  order by id ";
			pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next() ) {
				bean = new Board();
				bean.setId(rs.getString("id"));
				bean.setUserName(rs.getString("username"));
				bean.setContents(rs.getString("contents"));
				datas.add(bean);
			}
		} catch(Exception e) {
			System.out.print("전체 조회 오류 : " + e.getMessage());
		} finally {
			disconnect();
		}
		return datas;
	}
	
	public ArrayList<Board> selectPage(int firstRow, int lastRow) {
		ArrayList<Board> datas = new ArrayList<Board>();
		Board bean = null;
		try {
			connect();		
			//String sql="select * from ( select rownum num, board.* from board where id> ? order by id  ) where num < 10 ";
			//String sql="select * from board where id> ? order by id limit 1, 10 ";
			String sql = " select * (select *, rownum rnum ( "
			             + "select * from board where id> ? order by id "
						 + ")a ) b "
						 + " where rownum > ? and rnum < ? ";						 
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, firstRow);
			pstmt.setInt(2, lastRow);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next() ) {
				bean = new Board();
				bean.setId(rs.getString("id"));
				bean.setUserName(rs.getString("username"));
				bean.setContents(rs.getString("contents"));
				datas.add(bean);
			}
		} catch(Exception e) {
			System.out.print("페이지 조회 오류 : " + e.getMessage());
		} finally {
			disconnect();
		}
		return datas;
	}
	
	public int count() {
		int cnt = 0;
		try {
			connect();		
			String sql="select count(*) from countries ";
			
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
		} catch(Exception e) {
			System.out.print("조회 오류 : " + e.getMessage());
		} finally {
			disconnect();
		}
		return cnt;
	}
}
