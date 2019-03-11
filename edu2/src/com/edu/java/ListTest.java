package com.edu.java;

import java.util.*;

import com.edu.emp.EmpDTO;

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
		//list.clear(); //모두삭제
		System.out.println(list);
		//3. 변경
		list.set(0, "복숭아");
		//4. 조회
		list.contains("복숭아"); //검색 용도로 사용
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
		
		//EmpDTO List
		List<EmpDTO> empList = new ArrayList<EmpDTO>();
		empList.add(new EmpDTO("100", "홍길동", "2000"));
		empList.add(new EmpDTO("101", "김유신", "3000"));
		empList.add(new EmpDTO("102", "유관순", "1000"));
		//정렬
		Collections.sort(empList);
		System.out.println("--------정렬후----------");
		for(EmpDTO emp : empList) {
			System.out.println(emp);
		}
		//확장for문 이용해서 이름만 출력
		System.out.println("empList에 들어있는 이름만 출력");
		for(EmpDTO emp : empList) {
			System.out.println(emp.getFirst_name());
		}
		
		//iterator 이용해서 급여만 출력, 전체급여 계산
		int sum = 0;
		Iterator<EmpDTO> empIter = empList.iterator();
		System.out.println("empIter에 들어있는 급여만 출력");
		while(empIter.hasNext()) {
			String salary = empIter.next().getSalary();
			System.out.println(salary);
			sum += Integer.parseInt(salary);
		}
		System.out.println("전체 급여 : " + sum);
	}
}
