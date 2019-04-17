package com.jogiyo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;


import com.jogiyo.vo.FoodDTO;
import com.web.common.DAO;

public class FoodDAO  extends DAO {
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	// 싱글톤 : static 필드
	static FoodDAO instance;
	
	public static FoodDAO getInstance() {
		if (instance == null)
			instance = new FoodDAO();
		return instance; 
		
	}
	
	public HashMap<String, Object> selectOne(FoodDTO bean) throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			
			connect();
			stmt = conn.createStatement();
		
			String sql = "SELECT food_code, food_name from food where food_code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getFoodCode());			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				map.put("foodCode", rs.getString("food_code"));
				map.put("foodName", rs.getString("food_name"));
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
