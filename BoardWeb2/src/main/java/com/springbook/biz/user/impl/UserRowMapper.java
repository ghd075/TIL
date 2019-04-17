package com.springbook.biz.user.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springbook.biz.user.UserVO;

public class UserRowMapper implements RowMapper<UserVO> {

	@Override
	public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserVO users = new UserVO();
		users.setId(rs.getString("id"));
		users.setPassword(rs.getString("password"));
		users.setName(rs.getString("name"));
		users.setRole(rs.getString("role"));
		return users;
	}

}
