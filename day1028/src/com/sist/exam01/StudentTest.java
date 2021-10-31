package com.sist.exam01;

//쌤이랑 같이

import java.io.FileReader;

public class StudentTest {

	public static void main(String[] args) {

		try {
			FileReader fr = new FileReader("c:/myData/Student.txt");
			
			//파일로부터 한글자씩 읽어들이는 메소드 : read()
			//파일의 끝에 도달하면 -1를 반환
			
			
			//읽어들인 문자들을 모아서 문자열을 만들기 위한 변수
			//한문자씩 읽어들여서 누적하기 위하여 초기값 ""을 설정한다.
			String str ="";
			
			
			int ch;//파일로부터 한글자씩 읽어들이기 위한 변수
			while(true) {
				ch=fr.read();//파일로부터 한글자씩 읽어들인다
				if(ch == -1 ) {//파일의 끝에 도달하면 반복문을 탈출
					break;
				}
				//읽어들인 문자의 숫자값을 다시 문자로 형변환하여 변수에 저장
				char data = (char)ch;
				//System.out.print(data);
				
				//읽어들인 문자를 문자열 변수 str에 누적
				str = str +data;
				
			}
			//파일의 내용을 모두 읽고나면 반복문 탈출
			//파일을 닫아준다.
			fr.close();
			
			//반복문을 탈출하면 str에 파일의 내용이 담겨있을 것이다.
			System.out.println(str);
			
			
			//----------split메소드를 이용해 분리하자
			//split을 분리한 데이터들은 문자열 배열로 반환된다.
			String [] arr = str.split(",");
			String name = arr[0];
			
			//arr[1]은 String이므로 int로 변환하여 변수 kor에 저장한다.
			int kor = Integer.parseInt(arr[1]);
			int eng = Integer.parseInt(arr[2]);
			int math = Integer.parseInt(arr[3]);
			
			int tot = kor + eng + math;
			int avg = tot / 3;
			
			System.out.println("이름:"+name);
			System.out.println("국어:"+kor);
			System.out.println("영어:"+eng);
			System.out.println("수학:"+math);
			System.out.println("총점:"+tot);
			System.out.println("평균:"+avg);
			
			
			
		} catch (Exception e) {
			System.out.println("에외발생:"+e.getMessage());
		}

	}

}
