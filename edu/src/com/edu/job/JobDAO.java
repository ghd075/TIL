package com.edu.job;

import java.util.*;

import com.edu.common.ConnectionManager;

import java.sql.*;

public class JobDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 싱글톤 : static 필드
	static JobDAO instance;

	public static JobDAO getInstance() {
		if (instance == null)
			instance = new JobDAO();
		return instance;
	}

	// 전체조회
	public List<JobDTO> selectAll() {
		List<JobDTO> datas = new ArrayList<JobDTO>();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "select * from jobs order by job_id";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				JobDTO job = new JobDTO();
				job.setJob_id(rs.getString("job_id"));
				job.setJob_title(rs.getString("job_title"));
				datas.add(job); // dto를 리스트에 추가
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
