package com.sist.exam01;

//���̶� ����

import java.io.FileReader;

public class StudentTest {

	public static void main(String[] args) {

		try {
			FileReader fr = new FileReader("c:/myData/Student.txt");
			
			//���Ϸκ��� �ѱ��ھ� �о���̴� �޼ҵ� : read()
			//������ ���� �����ϸ� -1�� ��ȯ
			
			
			//�о���� ���ڵ��� ��Ƽ� ���ڿ��� ����� ���� ����
			//�ѹ��ھ� �о�鿩�� �����ϱ� ���Ͽ� �ʱⰪ ""�� �����Ѵ�.
			String str ="";
			
			
			int ch;//���Ϸκ��� �ѱ��ھ� �о���̱� ���� ����
			while(true) {
				ch=fr.read();//���Ϸκ��� �ѱ��ھ� �о���δ�
				if(ch == -1 ) {//������ ���� �����ϸ� �ݺ����� Ż��
					break;
				}
				//�о���� ������ ���ڰ��� �ٽ� ���ڷ� ����ȯ�Ͽ� ������ ����
				char data = (char)ch;
				//System.out.print(data);
				
				//�о���� ���ڸ� ���ڿ� ���� str�� ����
				str = str +data;
				
			}
			//������ ������ ��� �а��� �ݺ��� Ż��
			//������ �ݾ��ش�.
			fr.close();
			
			//�ݺ����� Ż���ϸ� str�� ������ ������ ������� ���̴�.
			System.out.println(str);
			
			
			//----------split�޼ҵ带 �̿��� �и�����
			//split�� �и��� �����͵��� ���ڿ� �迭�� ��ȯ�ȴ�.
			String [] arr = str.split(",");
			String name = arr[0];
			
			//arr[1]�� String�̹Ƿ� int�� ��ȯ�Ͽ� ���� kor�� �����Ѵ�.
			int kor = Integer.parseInt(arr[1]);
			int eng = Integer.parseInt(arr[2]);
			int math = Integer.parseInt(arr[3]);
			
			int tot = kor + eng + math;
			int avg = tot / 3;
			
			System.out.println("�̸�:"+name);
			System.out.println("����:"+kor);
			System.out.println("����:"+eng);
			System.out.println("����:"+math);
			System.out.println("����:"+tot);
			System.out.println("���:"+avg);
			
			
			
		} catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}

	}

}
