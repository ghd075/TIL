package com.spirngbook.biz.common;

import org.aspectj.lang.JoinPoint;

//Advice 클래스
public class BeforeAdvice {
	public void beforeLog(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		System.out.println("[사전 처리] " + methodName +"비즈니스 로직 수행 전 동작"
							+ ((args != null && args.length>0) ? args[0] : ""));
	}
}
