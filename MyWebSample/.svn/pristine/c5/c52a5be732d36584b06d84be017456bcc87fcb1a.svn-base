package com.jogiyo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import com.jogiyo.vo.LocationDTO;
import com.web.common.DAO;

public class LocationDAO  extends DAO {
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	// 싱글톤 : static 필드
	static LocationDAO instance;
	
	public static LocationDAO getInstance() {
		if (instance == null)
			instance = new LocationDAO();
		return instance; 
		
	}
	
	public HashMap<String, Object> selectOne(LocationDTO bean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			
			connect();
			stmt = conn.createStatement();
		
			String sql = "SELECT loc_code, loc_name from locations where loc_code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getLocCode());			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				map.put("locCode", rs.getString("loc_code"));
				map.put("locName", rs.getString("loc_name"));
			}		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return map;
	}
}
