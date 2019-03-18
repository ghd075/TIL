package com.edu.test;

public class ExceptionTest {

	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		try {
			sub1();
		}catch (Exception e) {
			System.out.println("main : " + e.getMessage());
		}
		System.out.println("프로그램 종료");
	}
	
	
	public static void sub1() throws ArithmeticException {
		System.out.println("sub1 실행");
		sub2();
	}
	
	public static void sub2() throws ArithmeticException {
	 	System.out.println("sub2 실행");
	 	int a = 5/0;
	}
}
