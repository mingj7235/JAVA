package day37_FullScreen;

import java.awt.Color;
import java.awt.Container;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

public class FullScreen extends JFrame{
	public FullScreen() {
		this("제목없음");
	}
	public FullScreen(String title) {
		setTitle(title);
		Container con = this.getContentPane();
		con.setBackground(Color.green);
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		//현재 그래픽환경을 가져와준다. (외워야함)
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		//그래픽 장치를 가져와준다. 
		//객체화 할 수 없다. 왜? 싱글톤 패턴 -> 그래픽 상태는 1개뿐이니까.
		
		setUndecorated(true);
		//데코 안할거라는 것임
		
		gd.setFullScreenWindow(this);
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new FullScreen();
	}
}
