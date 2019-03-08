package com.edu.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.edu.common.ConnectionManager;

public class DeptDAO {
	//필드선언
	Connection conn=null;
	PreparedStatement psmt;
	ResultSet rs = null;	
	
	//싱글톤
	static DeptDAO instance;
	public static DeptDAO getInstance() {
		if(instance==null)
			instance=new DeptDAO();
		return instance;
	}
	
	//단건조회
	public DeptDTO selectOne(DeptDTO dto) {
		DeptDTO dept = new DeptDTO();
		try {
			conn=ConnectionManager.getConnnect();
			String sql="select * from departments where department_id=? ";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, dto.getDepartment_id());
			rs=psmt.executeQuery();
			if(rs.next()) {
				dept.setDepartment_id(rs.getString("department_id"));
				dept.setDepartment_name(rs.getString("department_name"));
				dept.setLocation_id(rs.getString("location_id"));
				dept.setManager_id(rs.getString("manager_id"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.close(rs,psmt,conn);
		}		
		return dept;
	}
	
	//전체조회
	
	public List<DeptDTO> selectAll(){
		List<DeptDTO> datas = new ArrayList<DeptDTO>();
		try {
			conn=ConnectionManager.getConnnect();
			String sql="select * from departments order by department_id";
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();		
			while(rs.next()) {
				DeptDTO dept = new DeptDTO();
				dept.setDepartment_id(rs.getString("department_id"));
				dept.setDepartment_name(rs.getString("department_name"));
				dept.setLocation_id(rs.getString("location_id"));
				dept.setManager_id(rs.getString("manager_id"));
				datas.add(dept);				
			}			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConnectionManager.close(conn);
		}	
		return datas;
	}
	
}
