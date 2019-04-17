package com.springbook.biz.user.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;

@Repository
public class UserDAOMybatis {
	
	//SqlSessionTemplate객체가 모든 JDBC처리를 대신 해줌
	@Autowired
	SqlSessionTemplate mybatis;
	
	public UserVO getUser(UserVO vo) {
		System.out.println("===> Mybatis로  getUser() 기능 처리");
		return (UserVO) mybatis.selectOne("UserDAO.getUser", vo);
	}
	
	public List<UserVO> getUserList() {
		System.out.println("===> Mybatis로  getUserList() 기능 처리");
		return mybatis.selectList("UserDAO.getUserList");

	}
	
	public Integer userCount() {
		System.out.println("===> Mybatis로   userCount() 기능 처리");
		return  mybatis.selectOne("UserDAO.userCount");
	}
	
	public List<Map<String, Object>> getUserMap(UserVO vo) {
		System.out.println("===> Mybatis로 	getUserMap() 기능 처리");
		return mybatis.selectList("UserDAO.getUserMap", vo);
	}
}
