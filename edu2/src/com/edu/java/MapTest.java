package com.edu.java;
/* 
 * Key로 등록하고 조히
 * Key는 중복 안 도미
 * 검색
 */

import java.util.*;

import com.edu.emp.EmpDTO;

public class MapTest {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		//추가
		map.put("1", "수박");
		map.put("2", "오렌지");
		//수정
		map.replace("2", "사과");	//map.put("2", "사과");
		//삭제
		map.remove("1");
		//조회
		System.out.println(map.get("1"));
		//전체조회
		Iterator<String> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			String value = map.get(key);
			System.out.println(value);
		}
		
		//응용문제
		Map<String, EmpDTO> empMap = new HashMap<String, EmpDTO>();
		empMap.put("101", new EmpDTO("101","유관순","1000"));
		empMap.put("102", new EmpDTO("102","홍길동","2000"));
		//102번 사원의 이름은?
		System.out.println(empMap.get("102").getFirst_name());
	}
}
