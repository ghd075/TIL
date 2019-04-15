package com.spirngbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getSignature().getName();
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		Object obj = pjp.proceed(); //포인트컷(서비스 메서드) 호출
		
		stopWatch.stop();
		
		System.out.println("[around] "  +  methodName + " : "  + stopWatch.getTotalTimeMillis());
		
		/*
		 * System.out.println("[BEFORE]: 비즈니스 메소드 수행 전에 처리할 내용..."); Object obj =
		 * pjp.proceed(); //포인트컷(서비스 메서드) 호출 -> 실행
		 * System.out.println("[AFTER]: 비즈니스 메소드 수행 후에 처리할 내용...");
		 */
		return obj;
	}
}
