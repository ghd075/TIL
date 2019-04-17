package com.springbook.biz.user;

import java.util.List;

public interface UserService {
	
	//CRUD 기능의 메소드 구현
	//로그인
	public UserVO getUser(UserVO vo);
	//회원 목록 조회
	public List<UserVO> getUserList();
}
