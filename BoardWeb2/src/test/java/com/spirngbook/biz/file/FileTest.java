package com.spirngbook.biz.file;

import java.io.File;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) throws IOException {
		
		//폴더목록조회
		File dir = new File("D:\\upload");
		//String[]  list = dir.list();//경로의 파일들과 폴더를 문자열 배열로 반환
		File[] list = dir.listFiles(); //해당 경로의 파일들과 폴더의 파일을 배열로 반환
		for(int i = 0; i<list.length; i++) {
			//System.out.println(list[i]);
			File f = list[i];
			if(f.isDirectory()) { //해당 경로가 폴더이면
				System.out.println("[" + f.getName() + "]");
			}else {
				System.out.println(f.getName() + " " +  //파일이나 폴더의 이름
								   f.length()/1024 + "KR " + //파일의 크기								   
								   f.lastModified());  //해당 경로 파일의 최종 수정 일자
			}
			System.out.println();
		}
		//파일정보확인(생성일자, 크기..)
		
		//파일생성
		File newFile = new File("C:\\Temp\\sample.txt");
		//newFile.createNewFile();
		
		//폴더생성
		File newDir = new File("C:\\Temp","data");
		//newDir.mkdir();
		
		//파일삭제
		//newFile.delete();
		
		//폴더삭제
		newDir.delete();

	}

}
