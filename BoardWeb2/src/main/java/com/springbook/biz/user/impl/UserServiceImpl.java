package com.springbook.biz.user.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	//private UserDAO userDAO;
	//private UserDAOSpring userDAO;
	private UserDAOMybatis userDAO;
	
	@Override
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}
	
	@Override
	public List<UserVO> getUserList() {
		return userDAO.getUserList();
	}
	
	@Override
	public Integer userCount() {
		return userDAO.userCount();
	}
	
	@Override
	public List<Map<String, Object>> getUserMap(UserVO vo) {
		return userDAO.getUserMap(vo);
	}

}
