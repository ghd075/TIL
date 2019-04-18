package com.spirngbook.biz.user;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/applicationContext.xml")
public class UserClient {
	@Autowired
	UserService service;
	
	UserVO vo;
	
	@Before
	public void init() {
		vo = new UserVO();
	}
	
	@Test
	public void test() {
		vo.setId("user1");
		vo.setPassword("user1");
		assertNotNull(service.getUser(vo));
	}
}
