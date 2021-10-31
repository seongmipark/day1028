package com.sist.exam03;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class StudentTestObjectInPutStream {

	public static void main(String[] args) {
		//"c:/myData/lee.stu"
		
		try {
			//��ü������ �Է��� ���� ObjectInputStream��ü�� ����
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:/myData/lee.stu"));
			
			//���Ϸκ��� ��ü�� �о�鿩 ��ü���������� ����
			Student lee = (Student)ois.readObject();
			
			//��ü ������ ���
			System.out.println("�̸�:"+lee.getName());
			System.out.println("����:"+lee.getKor());
			System.out.println("����:"+lee.getEng());
			System.out.println("����:"+lee.getMath());
		
			//���ϴݱ�
			ois.close();
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}

}
