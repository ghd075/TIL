package com.dev.service;

import java.util.ArrayList;

import com.dev.vo.DeptBeans;
import com.dev.vo.DeptDAO;

//업무단위로 처리
public class DeptService {
	
	DeptDAO dao = DeptDAO.getInstance();
	
	//싱글톤
	private static DeptService service = new DeptService();
	public static DeptService getInstance() {
		return service;
	}
	
	//전체 조회
	public ArrayList<DeptBeans> selectAll(){
		return dao.selectAll();
	}
	
	//등록
	public void deptInsert(DeptBeans vo) {
		dao.deptInsert(vo);
	}
}
