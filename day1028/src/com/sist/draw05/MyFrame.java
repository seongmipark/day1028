package com.sist.draw05;


import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MyFrame extends JFrame implements ActionListener {
	private LinePanel lp;
	
	public MyFrame() {
		lp = new LinePanel();
		add(lp);
		//�޴��ٸ� �����մϴ�.
				JMenuBar jmb = new JMenuBar();
				
				//�ָ޴� "����"�� ����
				JMenu  mn_file = new JMenu("����");
				
				//�ָ޴� "�׸��⵵��"�� ����
				JMenu mn_draw = new JMenu("�׸��⵵��");
				
				//�θ޴� "������"�� ����
				JMenuItem file_new = new JMenuItem("������");
				
				//�θ޴� "����"�� ����
				JMenuItem file_open = new JMenuItem("����");
				
				//�θ޴� "����"�� ����
				JMenuItem file_save = new JMenuItem("����");
				
				//"�θ޴�"���� "�ָ޴�"�� ���
				mn_file.add(file_new);
				mn_file.add(file_open);
				mn_file.add(file_save);
				
				
				//�ָ޴� "�׸��⵵��"�� ��� �θ޴�
				JMenuItem draw_line = new JMenuItem("��");
				JMenuItem draw_rect = new JMenuItem("�簢��");
				JMenuItem draw_oval = new JMenuItem("��");
				
				//��,�簢��,�� �θ޴����� "�׸��⵵��"�ָ޴�
				mn_draw.add(draw_line);
				mn_draw.add(draw_rect);
				mn_draw.add(draw_oval);		
				
				//"�ָ޴�"�� "�޴���"�� ��� 
				jmb.add(mn_file);
				
				//"�׸��⵵��" �ָ޴��� "�޴���"�� ���
				jmb.add(mn_draw);
				
				//"�޴���"�� "������"�� ����
				setJMenuBar(jmb);
				
				//������ JMenuItem�� ���Ͽ� �̺�Ʈ�� ���
				file_new.addActionListener(this);
				file_open.addActionListener(this);
				file_save.addActionListener(this);
				
				//�׸��⵵���� �θ޴��鿡 ���ؼ��� �̺�Ʈ�� ���
				draw_line.addActionListener(this);
				draw_rect.addActionListener(this);
				draw_oval.addActionListener(this);
				
				setSize(600,400);
				setVisible(true);
				setTitle("���׸���");
			}

			
			//������ JMenuItem�� ������ actionPerformed�޼ҵ尡 �����մϴ�.
			@Override
			public void actionPerformed(ActionEvent e) {
				//JMenuItem�߿� � �޴��� ���������� �ľ��ϱ� ���Ͽ� �Ű����� ActionEvent�� getActionCommand()�� �̿�
				String cmd = e.getActionCommand();
				//System.out.println(cmd+"�� ������");
				
				if(cmd.equals("����")) {
					try {
						// ���� ȭ�鿡 �׷��� ��� "��"���� ���Ϸ� �����ؿ�.("c:/myData/data.pan")
						// ����ȭ�鿡 �׷��� ��� "��"���� ������ LinePanel ��ü�� lp�� list�� ������ִ�.
						// list��ü�� ��°�� ���Ϸ� ����ϱ� ���Ͽ� ObjectOutputStream�� �̿��Ѵ�.
						ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:/myData/data.pan"));
						
						//LinePanel ��ü�� �ɹ������� list�� ���Ϸ� ���
						oos.writeObject(lp.list);
						
						oos.close();
						
					}catch (Exception ex) {
						System.out.println("���ܹ߻�:"+ex.getMessage());
					}
					
				}else if(cmd.equals("����")) {
					//"c:/myData/data.pan"������ ������ �о� �鿩
					// LinePanel ��ü�� lp�� list �� �����Ѵ�.
					// ȭ���� �ٽ� �׸��� ���Ͽ� Linepanel ��ü�� lp�� repaint�� ȣ���Ѵ�.
					
					try {
						//��ü������ ������ ������ �о���̱� ���Ͽ� ObjectInputStream��ü�� �����Ѵ�.
						ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:/myData/data.pan"));
						
						//���Ϸ� �����͸� �о�鿩 Linpanel ��ü�� lp�� list�� ���
						lp.list = (ArrayList<GraphicInfo>)ois.readObject();
						
						//������ ������ �о�ͼ� list�� ��� �׷����� ������ŭ �ٽ� �׷��ֱ� ���Ͽ� repaint�� ȣ��
						lp.repaint();
						
						//���ϴݱ�
						ois.close();
	
					}catch (Exception ex) {
						System.out.println("���ܹ߻�:"+ex.getMessage());
					}
					
					
				}else if(cmd.equals("������")) {
					System.out.println("�������� ó���Դϴ�.");
				}else if(cmd.equals("��")) {
					lp.drawType=0;
				}else if(cmd.equals("�簢��")) {
					lp.drawType=1;
				}else if(cmd.equals("��")) {
					lp.drawType=2;
				}
			}
		}
