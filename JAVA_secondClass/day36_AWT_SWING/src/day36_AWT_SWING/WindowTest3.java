package day36_AWT_SWING;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class WindowTest3 {
	public static void main(String[] args) {
		JFrame window = new JFrame("제목 있는 윈도우");
		window.setBounds(1200, 200, 400, 300);
		
		//swings에서는 컨테이너를 만들고, 거기에서 contentpane 을 get하여서 여기에 백그라운드 칼라를 정해야한다. 
		Container con = window.getContentPane();
		con.setBackground(Color.black);
		
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}
