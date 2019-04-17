package com.jogiyo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.web.common.DAO;

public class StatisDao extends DAO {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//싱글톤  : static 필드
	static StatisDao instance;	
	public static StatisDao getInstance() {
		if (instance == null)
			instance = new StatisDao();
		return instance;
	}
	
	public List<Map<String,Object>> selectFood(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try {
			connect();
			String sql = "select food_name, count(a.food_code) cnt from food a, board b where a.food_code = b.food_code group by a.food_name";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("food_name", rs.getString("food_name"));
				map.put("cnt", rs.getString("cnt"));
				list.add(map);
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}	
		return list;
		}
	
	public List<Map<String,Object>> LocationFood(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try {
			connect();
			String sql = "select l.loc_name, count(*) cnt from board b, locations l,food f\r\n" + 
						 "where b.loc_code = l.loc_code\r\n" + 
						 "and b.food_code = f.food_code\r\n" + 
						 "group by l.loc_name order by 1,2";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("loc_name", rs.getString("loc_name"));
				map.put("cnt", rs.getString("cnt"));
				list.add(map);
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}	
		return list;
		}
	
	public List<Map<String,Object>> RankFood(){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try {
			connect();
			String sql = "select u.user_code, u.board_no, b.cnt from likes u, board b";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("user_code", rs.getString("user_code"));
				map.put("board_no", rs.getString("noard_no"));
				map.put("cnt", rs.getString("cnt"));
				list.add(map);
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}	
		return list;
		}
}
