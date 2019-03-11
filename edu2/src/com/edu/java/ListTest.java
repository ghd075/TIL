package com.edu.java;

import java.util.*;

public class ListTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		//1. 추가
		list.add("사과");
		list.add("바나나");
		list.add(0,"수박"); //0번지에 삽입
		System.out.println(list);
		//2. 삭제
		list.remove("수박"); //list.remove(0)
		System.out.println(list);
		//3. 변경
		list.set(0, "복숭아");
		//4. 조회
		//첫번째 for문
		System.out.println("for문 사용");
		for(int i=0; i<list.size(); i++) {
			String temp = list.get(i);
			System.out.println(temp);
		}
		//두번째 확장 for
		System.out.println("확장 for문 사용");
		for(String temp : list) {
			System.out.println(temp);
		}
		//iterator : 일렬로 줄을 세운다.(읽어내는 속도가 빠름)
		System.out.println("iterator 사용");
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			String temp = iter.next();
			System.out.println(temp);			
		}
	}

}
