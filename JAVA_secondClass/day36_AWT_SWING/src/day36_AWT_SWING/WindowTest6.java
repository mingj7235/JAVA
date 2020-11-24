package day36_AWT_SWING;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class WindowTest6 extends Frame{
	//정중앙에 뜨도록하기
	public WindowTest6() {
		this("제목 없는 윈도우");
	}
	public WindowTest6(String title) {
		
		setResizable(false);
		//사이즈를 줄일수 없게 하는 것. 
		
		setTitle(title);
		setSize(1200, 500);
		setBounds(1200, 200, 400, 300);
		Dimension dimen1 = Toolkit.getDefaultToolkit().getScreenSize();
		//dimen1 에는 컴퓨터의 모니터 해상도
		Dimension dimen2 = getSize();
		//dimen2 에는 frame의 해상도
		
		//해상도를 가져와주는 메서드
		//<모니터 정가운데로 윈도우창 위치시키는 법>
//		setLocation((모니터 해상도.width - 윈도우 크기.width)/2, (모니터 해상도.height - 윈도우 크기.height)/2);
		int x = (dimen1.width-dimen2.width)/2;
		int y = (dimen1.height-dimen2.height)/2;
		
		setLocation(x, y);
		setBackground(new Color(new Random().nextInt(16581376)));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose ();
			}
		});
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new WindowTest6("정중앙");
	}
}
