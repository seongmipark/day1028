package com.sist.exam02;

import java.io.FileWriter;

public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student lee = new Student("�̰ǿ�", 100, 100, 100);
		
		//Student ��ü�� lee�� ������ ���Ϸ� ����ϰ� ������
		// -���ڴ����� ���(�̸�,����,����,������ ��� ���ڿ��� ����� ���ʷ� ���)
		// -����Ʈ������ ���(��ü�� ��ä�� ���)
		
		
		try {
			FileWriter fw = new FileWriter("c:/myData/lee.txt");
			fw.write(lee.getName()+",");
			fw.write(lee.getKor()+",");
			fw.write(lee.getEng()+",");
			fw.write(lee.getMath()+"");
			
			//���ϻ���̳����� �ݾ��ش�
			fw.close();
			System.out.println("���ϻ����Ϸ�");

		} catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
	}

}
