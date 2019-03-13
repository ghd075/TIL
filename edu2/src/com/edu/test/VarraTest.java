package com.edu.test;
/*
 * 가변인자
 */
public class VarraTest {

	public static void main(String[] args) {
		sum(10,20);
		sum(10,20,30);		
	}
	
	public static void sum(int...nums) {
		int total = 0;
		for(int i=0; i<nums.length; i++) {
			total += nums[i];
		}
		System.out.println(total);
	}

}
