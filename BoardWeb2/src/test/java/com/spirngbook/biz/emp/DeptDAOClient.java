package com.spirngbook.biz.emp;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springbook.biz.emp.DeptVO;
import com.springbook.biz.emp.impl.DeptDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:config/applicationContext.xml",
									"classpath:config/context-mapper.xml"})
public class DeptDAOClient {

	@Autowired
	DeptDAO dao;
	
	@Test
	public void test() {
		DeptVO vo = new DeptVO();
		vo.setDepartmentId("10");
		System.out.println(dao.getDept(vo));
	}

}
