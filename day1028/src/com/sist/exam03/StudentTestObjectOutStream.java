package com.sist.exam03;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;

public class StudentTestObjectOutStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student lee = new Student("이건우", 100, 100, 100);
		
		//Student 객체인 lee의 정보를 파일로 기록하고 싶을때
		// -문자단위로 출력(이름,국어,영어,수학을 모두 문자열로 만들어 차례로 출력)
		// -바이트단위로 출력(객체를 통채로 출력)
		
		//바이트단위로 출력
		try {
			//객체단위로 출력하기 위한 ObjectOutputStream객체를 생성
			//이때 확장자는 텍스트파일이 아니기 때문에 .txt로 하지 않는다.
			//프로그램 성격에 맞도록 알맞게 확장자 이름을 정해준다.
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:/myData/lee.stu"));
			//객체를 출력한다
			oos.writeObject(lee);
			
			//파일사용이 끝났으면 닫아준다.
			oos.close();
			System.out.println("파일 생성완료");
			
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}

}
