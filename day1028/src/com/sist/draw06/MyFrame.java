package com.sist.draw06;


import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MyFrame extends JFrame implements ActionListener {
	private LinePanel lp;
	MyFrame mf;
	
	//저장할 파일명과 열어올 파일명을 선택할 수 있도록 하는 JFileChooser를 멤버변수로 선언
	JFileChooser jfc;
	
	public MyFrame() {
		lp = new LinePanel();
		add(lp);
		
		//JFileChooser 객체를 생성
		jfc = new JFileChooser("c:/myData");
		
		
		//메뉴바를 생성합니다.
		JMenuBar jmb = new JMenuBar();
		
		//주메뉴 "파일"을 생성
		JMenu  mn_file = new JMenu("파일");
		
		//주메뉴 "그리기도구"를 생성
		JMenu mn_draw = new JMenu("그리기도구");
		
		//부메뉴 "새파일"을 생성
		JMenuItem file_new = new JMenuItem("새파일");
		
		//부메뉴 "열기"를 생성
		JMenuItem file_open = new JMenuItem("열기");
		
		//부메뉴 "저장"을 생성
		JMenuItem file_save = new JMenuItem("저장");
		
		//"부메뉴"들을 "주메뉴"에 담기
		mn_file.add(file_new);
		mn_file.add(file_open);
		mn_file.add(file_save);
		
		
		//주메뉴 "그리기도구"에 담길 부메뉴
		JMenuItem draw_line = new JMenuItem("선");
		JMenuItem draw_rect = new JMenuItem("사각형");
		JMenuItem draw_oval = new JMenuItem("원");
		
		//선,사각형,원 부메뉴들을 "그리기도구"주메뉴
		mn_draw.add(draw_line);
		mn_draw.add(draw_rect);
		mn_draw.add(draw_oval);		
		
		//"주메뉴"를 "메뉴바"에 담기 
		jmb.add(mn_file);
		
		//"그리기도구" 주메뉴를 "메뉴바"에 담기
		jmb.add(mn_draw);
		
		//"메뉴바"를 "프레임"에 설정
		setJMenuBar(jmb);
		
		//각각의 JMenuItem에 대하여 이벤트를 등록
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		
		//그리기도구의 부메뉴들에 대해서도 이벤트를 등록
		draw_line.addActionListener(this);
		draw_rect.addActionListener(this);
		draw_oval.addActionListener(this);
		
		setSize(600,400);
		setVisible(true);
		setTitle("선그리기");
		}

		
		//각각의 JMenuItem을 누르면 actionPerformed메소드가 동작합니다.
		@Override
		public void actionPerformed(ActionEvent e) {
			//JMenuItem중에 어떤 메뉴가 눌러졌는지 파악하기 위하여 매개변수 ActionEvent의 getActionCommand()를 이용
			String cmd = e.getActionCommand();
			//System.out.println(cmd+"가 눌러짐");
			
			if(cmd.equals("저장")) {
				try {
					
					System.out.println("저장합니다.");
					//어디에 어떤 이름으로 저장할지 선택하도록 JFileChooser다이얼로그를 띄운다.
					int re = jfc.showSaveDialog(this);//Frame 자신에게 뜨도록 this
					
					
					//show다이얼로그에서 저장을 누르면 0을, 취소를 누르면 1을 반환한다.
					//저장을 누를때 파일이 저장되게 작성
					if(re == 0 ) {	
						//다이얼로그에서 선택한 파일을 갖고온다.
						File file = jfc.getSelectedFile();
						
						ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
						oos.writeObject(lp.list);
						oos.close();
					}
	
				}catch (Exception ex) {
					System.out.println("예외발생:"+ex.getMessage());
				}
				
			}else if(cmd.equals("열기")) {
				//열기에 대한 기능을 JFileChooser을 이용해서 열어올 파일을 선택하도록 구현
			
				try {	
				int re1 =  jfc.showOpenDialog(this); 
				File file = jfc.getSelectedFile();
				
				if(re1 == 0 ) {	
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
					lp.list = (ArrayList<GraphicInfo>)ois.readObject();
					lp.repaint();
					ois.close();		
				}

				}catch (Exception ex) {
					System.out.println("예외발생:"+ex.getMessage());
				}
				
				
			}else if(cmd.equals("새파일")) {
				
				mf.repaint();
				
				/*try  {
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:/myData/new.pan"));
					oos.writeObject(lp.list);
					oos.close();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}*/
				
				System.out.println("새파일의 처리입니다.");
			}else if(cmd.equals("선")) {
				lp.drawType=0;
			}else if(cmd.equals("사각형")) {
				lp.drawType=1;
			}else if(cmd.equals("원")) {
				lp.drawType=2;
			}
			}
		}
