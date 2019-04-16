package com.spirngbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//빈 등록
@Service
//Advice 클래스
@Aspect //Aspect = Pointcut + Advice
public class BeforeAdvice {
	//포인트 컷 설정
	@Pointcut("execution(* com.spirngbook.biz..*Impl.*(..))")
	public void allPointcut() {} //포인트 컷 이름 설정
	
	//어드바이스 설정
	@Before("allPointcut()") //포인트 컷 연결 및 동작시점 지정 
	public void beforeLog(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println("[사전 처리] " + methodName +"비즈니스 로직 수행 전 동작"
							+ ((args != null && args.length>0) ? args[0] : ""));
	}
}
