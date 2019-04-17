package com.springbook.biz.user;

import java.util.List;
import java.util.Map;

public interface UserService {
	
	//CRUD 기능의 메소드 구현
	//로그인
	public UserVO getUser(UserVO vo);
	//회원 목록 조회
	public List<UserVO> getUserList();
	//전체 건수 조회
	public Integer userCount();
	//Map으로 회원 목록 조회
	public List<Map<String, Object>> getUserMap(UserVO vo);
}
