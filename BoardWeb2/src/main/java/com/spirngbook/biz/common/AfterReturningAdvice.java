package com.spirngbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterReturningAdvice {
	
	/**
	 * 두 개 이상의 바인드 변수를 지정할 때는
	    콤마(,)로 분리하고 바인드 변수 명을 지정해 줌
	 * pointcut에서는 다른 클래스의 pointcut을 사용하려면
	   클래스명.포인터 컷 명으로 지정해주면 됨
	*/
	@AfterReturning(pointcut = "BeforeAdvice.allPointcut()", returning = "returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		String methodName = jp.getSignature().getName();
		System.out.println("[사후 처리]" + methodName + " : " + (returnObj != null ? returnObj : ""));
	}
}
