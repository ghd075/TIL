package com.spirngbook.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spirngbook.biz.user.UserVO;
@Repository
public class UserDAOSpring {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//SQL 명령어들
	private final String USER_GET = "select * from users where id = ? and password = ?";
	
	//회원 조회
	public UserVO getUser(UserVO vo) {
		System.out.println("===> Spring JDBC로  getUser() 기능 처리");
		Object[] args = {vo.getId(), vo.getPassword()};
		return jdbcTemplate.queryForObject(USER_GET, args, new UserRowMapper());
	}
}
