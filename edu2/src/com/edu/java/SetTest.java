package com.edu.java;

import java.util.*;
/**
 * Set : 순서 없고, 중복값 허용 안함
 * index 접근 불가 get() 메소드가 없음  
 */
public class SetTest {

	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<Integer>();
		//로또 생성기
		//난수 생성
		while(set.size()<6) {
			int num = (int)Math.floor(Math.random()*42) + 1;
			set.add(num);
		}
//		System.out.println(set);
//		Iterator로 전체 출력
		System.out.println("Iterator 사용");
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
		System.out.println("확장 for문 사용");
		for(Integer num : set) {
			System.out.print(num + " ");
		}
	}

}
