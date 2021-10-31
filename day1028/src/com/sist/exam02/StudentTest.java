package com.sist.exam02;

import java.io.FileWriter;

public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student lee = new Student("이건우", 100, 100, 100);
		
		//Student 객체인 lee의 정보를 파일로 기록하고 싶을때
		// -문자단위로 출력(이름,국어,영어,수학을 모두 문자열로 만들어 차례로 출력)
		// -바이트단위로 출력(객체를 통채로 출력)
		
		
		try {
			FileWriter fw = new FileWriter("c:/myData/lee.txt");
			fw.write(lee.getName()+",");
			fw.write(lee.getKor()+",");
			fw.write(lee.getEng()+",");
			fw.write(lee.getMath()+"");
			
			//파일사용이끝나면 닫아준다
			fw.close();
			System.out.println("파일생성완료");

		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}

}
