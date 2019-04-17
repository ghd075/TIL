package com.jogiyo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.jogiyo.dao.NoticeDao;
import com.jogiyo.vo.NoticeDto;
import com.web.common.DAO;

public class NoticeDao extends DAO{
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//싱글톤
	static NoticeDao instance = new NoticeDao();
	public static NoticeDao getInstance() {
		return instance;	
	}
	
	public int insert(NoticeDto dto) {
		int r = 0;
		try {
			connect(); 
			
			String sql="select max(notice_no) from notice";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				r = rs.getInt(1);
			r++;
			
			sql="insert into notice (notice_no,notice_title,notice_contents,n_date)"
					+ "values(?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, r);
			pstmt.setString(2, dto.getNotice_title());
			pstmt.setString(3, dto.getNotice_contents());
			
			
			int result = pstmt.executeUpdate();
			if (result != 1 )
				r=0;				
		}catch(Exception e) {
			System.out.println("입력오류발생" + e.getMessage());
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return r;
	}
	
	public boolean update(NoticeDto dto) {
		int result = 0;
		try {
			connect();
			String sql="update notice set N_date=sysdate,Notice_contents=?,Notice_title=? where notice_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getNotice_contents());
			pstmt.setString(2, dto.getNotice_title());
			pstmt.setString(3, dto.getNotice_no());
			
			
			result = pstmt.executeUpdate();
			if(result != 1)
				throw new Exception();
		} catch(Exception e) {
			System.out.println("수정오류:" + e.getMessage());
			return false;
		} finally {
			disconnect();
		}
		return true;
	}	
	
	public int delete(NoticeDto dto) {
		int n = 0;
		try {
				connect();
				String sql = " delete from notice "
						+	 " where notice_no= ? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getNotice_no());
				n = pstmt.executeUpdate();
	
}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return n;
	}
		
		public List<NoticeDto> selectAll() {
			List<NoticeDto> sel = new ArrayList<NoticeDto>();
			try {
				connect();
				String sql = "select * from notice order by notice_no";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					NoticeDto not = new NoticeDto();
					not.setN_date(rs.getString("n_date"));
					not.setNotice_contents(rs.getString("notice_contents"));
					not.setNotice_no(rs.getString("notice_no"));
					not.setNotice_title(rs.getString("notice_title"));
					sel.add(not);   
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				disconnect();
			}
			return sel;
		}	
		
		//단건조회
		public NoticeDto getNotice(String notice_no) {
			NoticeDto nd = null;
			try {
				connect();
				String sql ="SELECT notice_no, notice_contents, notice_title, n_date "
						+   " FROM notice"
						+   " WHERE notice_no = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, notice_no);
				
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					nd = new NoticeDto();
					nd.setNotice_no(rs.getString("notice_no"));
					nd.setNotice_contents(rs.getString("notice_contents"));
					nd.setNotice_title(rs.getString("notice_title"));
					nd.setN_date(rs.getString("n_date"));
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally{
				//5. 연결해제 
				disconnect();
			}  
			return nd;
	}
		
		//공지사항 긴급공지 select 쿼리
		public NoticeDto SelectNotice() {
			NoticeDto nd = null;
			try {
				connect();
				String sql =				
						"select*from(select a.*, rownum rn from("
						+ " SELECT notice_no, notice_contents, notice_title, n_date from notice order by notice_no desc"
						+ " ) a ) b where rn=1";				
				pstmt = conn.prepareStatement(sql);			
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					nd = new NoticeDto();
					nd.setNotice_no(rs.getString("notice_no"));
					nd.setNotice_contents(rs.getString("notice_contents"));
					nd.setNotice_title(rs.getString("notice_title"));
					nd.setN_date(rs.getString("n_date"));
				}
			} catch(Exception e) {
				e.printStackTrace();
			} finally{
				//5. 연결해제 
				disconnect();
			}  
			return nd;
	}
			
}

		

	

