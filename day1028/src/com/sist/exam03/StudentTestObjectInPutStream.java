package com.sist.exam03;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class StudentTestObjectInPutStream {

	public static void main(String[] args) {
		//"c:/myData/lee.stu"
		
		try {
			//객체단위로 입력을 위한 ObjectInputStream객체를 생성
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:/myData/lee.stu"));
			
			//파일로부터 객체를 읽어들여 객체참조변수에 저장
			Student lee = (Student)ois.readObject();
			
			//객체 정보를 출력
			System.out.println("이름:"+lee.getName());
			System.out.println("국어:"+lee.getKor());
			System.out.println("영어:"+lee.getEng());
			System.out.println("수학:"+lee.getMath());
		
			//파일닫기
			ois.close();
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}

}
