package com.edu.dept;

import java.sql.*;
import java.util.*;

import com.edu.common.ConnectionManager;

public class DeptDAO {
	//필드선언
	private Connection conn = null;	
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	//싱글
	static DeptDAO instance;
	public static DeptDAO getInstance() {
		if(instance == null)
			instance = new DeptDAO();
		return instance;
	}
	//단건조회
	public DeptDTO selectOne(DeptDTO dto) {
		DeptDTO dept = new DeptDTO();
		try {
			conn = ConnectionManager.getConnnect();
			String sql = "select * from departments where department_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getDepartment_id());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dept.setDepartment_id(rs.getString("department_id"));
				dept.setDepartment_name(rs.getString("department_name"));
				dept.setManager_id(rs.getString("manager_id"));
				dept.setLocation_id(rs.getString("location_id"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//연결해제
			ConnectionManager.close(conn);
		}
		return dept;
	}
}
