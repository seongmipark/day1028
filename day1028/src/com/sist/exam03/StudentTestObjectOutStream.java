package com.sist.exam03;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;

public class StudentTestObjectOutStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student lee = new Student("�̰ǿ�", 100, 100, 100);
		
		//Student ��ü�� lee�� ������ ���Ϸ� ����ϰ� ������
		// -���ڴ����� ���(�̸�,����,����,������ ��� ���ڿ��� ����� ���ʷ� ���)
		// -����Ʈ������ ���(��ü�� ��ä�� ���)
		
		//����Ʈ������ ���
		try {
			//��ü������ ����ϱ� ���� ObjectOutputStream��ü�� ����
			//�̶� Ȯ���ڴ� �ؽ�Ʈ������ �ƴϱ� ������ .txt�� ���� �ʴ´�.
			//���α׷� ���ݿ� �µ��� �˸°� Ȯ���� �̸��� �����ش�.
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:/myData/lee.stu"));
			//��ü�� ����Ѵ�
			oos.writeObject(lee);
			
			//���ϻ���� �������� �ݾ��ش�.
			oos.close();
			System.out.println("���� �����Ϸ�");
			
		} catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
	}

}
