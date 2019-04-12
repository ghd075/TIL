package com.spirngbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("[BEFORE]: 비즈니스 메소드 수행 전에 처리할 내용...");
		Object obj = pjp.proceed(); //포인트컷(서비스 메서드) 호출 -> 실행
		System.out.println("[AFTER]: 비즈니스 메소드 수행 후에 처리할 내용...");
		return obj;
	}
}
