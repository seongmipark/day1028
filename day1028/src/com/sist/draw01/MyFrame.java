package com.sist.draw01;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	private LinePanel lp;
	
	public MyFrame() {
		lp = new LinePanel();
		add(lp);
		setSize(600,400); //창 사이즈설정
		setVisible(true); //창 보이기
		setTitle("선그리기");
	}
	

}
