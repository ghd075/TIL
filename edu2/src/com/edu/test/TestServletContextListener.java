package com.edu.test;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//application == ServletContext == 컨테이너
@WebListener //web.xml에 등록하지 않고 자동으로 실행이 되는 데몬을 생성
//web.xml의 listener와 완전 동일한 기능
public class TestServletContextListener implements ServletContextListener, ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		//application.setAttribute();와 동일
		System.out.println("속성 추가");
		
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		//application.removeAttribute();와 동일
		System.out.println("속성 삭제");
		
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("속성 변경");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// 톰캣 서버(웹 어플리케이션)를 중단하면 호출되는 메소드
		System.out.println("어플리케이션 중지");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 톰캣 서버(웹 어플리케이션)를 시작하면 호출되는 메소드
		System.out.println("어플리케이션 시작");
		
	}

}
