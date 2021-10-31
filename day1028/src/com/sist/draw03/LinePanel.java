package com.sist.draw03;

import java.awt.Graphics;

import java.awt.event.MouseListener;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;

public class LinePanel extends JPanel implements MouseListener {
	int x1 = 0;
	int y1 = 0;
	int x2 = 0;
	int y2 = 0;
	
	//�����ڿ��� "���콺�̺�Ʈ"�� ���
	public LinePanel() {
		
		//this�� �ǹ̴� ���콺�̺�Ʈ�� �߻��Ͽ����� �̺�Ʈ ó�� ��簴ü�� '�ڽ�'�̶�� �ǹ�
		addMouseListener(this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		System.out.println("�ٽ� �׷��ݴϴ�.");
		g.drawLine(x1,y1,x2,y2);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		x1 = e.getX();
		y1 = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		x2 = e.getX();
		y2 = e.getY();		
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}


