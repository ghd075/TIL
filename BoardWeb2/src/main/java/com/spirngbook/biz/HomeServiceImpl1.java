package com.spirngbook.biz;

import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl1 implements HomeService {

	@Override
	public void print() {
		System.out.println("HomeServiceImpl1 실행");
	}
}
