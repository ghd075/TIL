package com.edu.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * 1. 래퍼 클래스 8개의 용도
 * 	- 기본데이터형을 객체화
 *  - 타입변환
 */
public class WrapperTest {

	public static void main(String[] args) {
		//int -> Integer
		int i = 10;
		Integer objInt = new Integer(i); //기본적인 방법
		objInt = i; //auto-boxing
		//Interger -> int
		i = objInt; //auto-unboxing
		i = objInt.intValue(); //기본적인 방법
		//String -> int
		String s = "100";
		i = Integer.parseInt(s);
		//int -> String
		s = Integer.toString(i);
		//String -> long
		long l;
		l = Long.parseLong(s);
		//long -> String
		s = Long.toString(l);
		//String -> Date
		String today1 = "2019-03-05 02:53";
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			Date day1 = transFormat.parse(today1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//Date -> String
		Date day2 = new Date();
		String today2 = transFormat.format(day2);
		
		//날짜
		Date today = new Date();
		long day3 = today.getTime();
		Calendar day4 = Calendar.getInstance();
		day4.set(2019, 3, 10);
		long diff = day4.getTimeInMillis() - day3;
		System.out.println("남은 일수 = " + diff/1000/60/60/24);
		
		// Date -> String ( oracle to_char()  )
		System.out.println(today);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		System.out.println(formatter.format(today));
		
		//String -> Date
		String day5 = "2019-03-01";
		String[] day6 = day5.split("-");
		int y = Integer.parseInt(day6[0]);
		int m = Integer.parseInt(day6[1]);
		int d = Integer.parseInt(day6[2]);
//		day4.set(y, m, d);
		day4.set(Calendar.YEAR, y);
		day4.set(Calendar.MONTH, m);
		day4.set(Calendar.DAY_OF_MONTH, d);
		System.out.println(day2);
		System.out.println("year : " + day4.get(Calendar.YEAR));
		System.out.println("month : " + day4.get(Calendar.MONTH));
		System.out.println("day : " + day4.get(Calendar.DAY_OF_MONTH));
		System.out.println(day2);
	}
}
