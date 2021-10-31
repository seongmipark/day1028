package com.sist.text;


//ȥ�� �����غ���

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;


public class Notepad extends JFrame implements ActionListener {
	
	JFileChooser jfc;
	Notepad np;
	JTextArea ja;
	public Notepad() {
		jfc = new JFileChooser("c:/myData");

		ja = new JTextArea();
		add(ja);		

		JMenuBar jmb = new JMenuBar();
		JMenu mu_file = new JMenu("����");
		JMenuItem file_new= new JMenuItem("������");
		JMenuItem file_open = new JMenuItem("����");
		JMenuItem file_save = new JMenuItem("����");
		
		mu_file.add(file_new);
		mu_file.add(file_open);
		mu_file.add(file_save);
		jmb.add(mu_file);
		
		setJMenuBar(jmb);
		
		setSize(600,600);
		setVisible(true);
		setTitle("�޸���");
		
		mu_file.addActionListener(this);

		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		//System.out.println(cmd);
		
		if(cmd.equals("������")) {
			
		}else if(cmd.equals("����")) {
			try {
			int re =  jfc.showOpenDialog(this); 
			File file = jfc.getSelectedFile();
			
			if(re == 0) {
					FileReader fr = new FileReader(file);
					int ch;
					String str="";
					while(true) {
						ch=fr.read();//���Ϸκ��� �ѱ��ھ� �о���δ�
						if(ch == -1 ) {//������ ���� �����ϸ� �ݺ����� Ż��
							break;
						}
						char data = (char)ch;
						str = str + data;
					}
					
					ja.append(str);
					
					fr.close();		
				}
			
			}catch(Exception ex) {
			}			
		}else if(cmd.equals("����")) {
			try {

				int re = jfc.showSaveDialog(this);
				File file = jfc.getSelectedFile();
				
				FileWriter fw = new FileWriter(file);
				fw.write(ja.getText());
				
				fw.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
			
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		Notepad note = new Notepad();		
	
	}


}
