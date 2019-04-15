package com.spirngbook.biz.common;

import org.aspectj.lang.JoinPoint;


public class AfterReturningAdvice {
	public void afterLog(JoinPoint jp, Object returnObj) {
		String methodName = jp.getSignature().getName();
		System.out.println("[사후 처리]" + methodName + " : " + (returnObj != null ? returnObj : ""));
	}
}
