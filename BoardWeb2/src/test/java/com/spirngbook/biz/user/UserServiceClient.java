package com.spirngbook.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVO;

public class UserServiceClient {

	public static void main(String[] args) {
		//1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		//2. Spring 컨테이너로부터 UserServiceImpl 객체를 Lookup한다.
		UserService service = container.getBean(UserService.class); //클래스 type으로 검색
		
		UserVO vo = new UserVO();
		vo.setId("user01");
		vo.setPassword("user01");
		
		UserVO user = service.getUser(vo);
		if(user != null) {
			System.out.println(user.getName() + "님 환영합니다.");
		}else {
			System.out.println("로그인 실패");
		}

	}

}
