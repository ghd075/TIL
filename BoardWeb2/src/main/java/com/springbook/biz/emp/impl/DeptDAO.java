package com.springbook.biz.emp.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.emp.DeptVO;

@Repository
public class DeptDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	//삽입
	public void insertDept(DeptVO vo) {
		System.out.println("===> Mybatis로  insertDept() 기능 처리");
		mybatis.insert("emp.insertDept",vo);
	}
	
	//수정
	public void updateDept(DeptVO vo) {
		System.out.println("===> Mybatis로  updateDept() 기능 처리");
		mybatis.update("emp.updateDept",vo);
	}
	
	//삭제
	public void deleteDept(DeptVO vo) {
		System.out.println("===> Mybatis로  deleteDept() 기능 처리");
		mybatis.delete("emp.deleteDept",vo);
	}
	
	//단건조회
	public DeptVO getDept(DeptVO vo) {
		System.out.println("===> Mybatis로  getDept() 기능 처리");
		return mybatis.selectOne("emp.getDept", vo);
	}
}
