package com.spirngbook.biz.emp;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Ignore;
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
	
	@Ignore
	public void test1() {
		DeptVO vo = new DeptVO();
		vo.setDepartmentId("20");
		System.out.println(dao.getCount());
	}
	
	@Ignore
	public void test() {
		DeptVO vo = new DeptVO();
		vo.setDepartmentId("10");
		System.out.println(dao.getDept(vo));
	}
	
	@Ignore
	public void test2() {
		DeptVO vo = new DeptVO();
		//vo.setDepartmentId("20");
		List<Map<String, Object>> list = dao.getDeptCnt();
		for(Map<String, Object> temp : list) {
			System.out.println(temp.get("id") + " : " + temp.get("name") + " : " + temp.get("cnt"));
		}
	}
	
	@Test
	public void test3() {
		DeptVO vo = new DeptVO();
		vo.setDepartmentName("디자인팀");
		dao.insertDept(vo);
		System.out.println("등록된 부서번호 : " + vo.getDepartmentId());
	}
}
