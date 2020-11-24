package day22_anonymousClass;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ButtonTest extends Frame{
	
	public ButtonTest() {
		super("익명 클래스 테스트");
		//Frame 부모클래스 생성자에 문자열을 넣으면 버튼 창의 타이틀이 된다.
		Button btn = new Button("눌러!");
		//Button 생성자에 문자열을 넣으면 버튼에 글자가 들어감
		add(btn);
		//프레임에 버튼을 추가하는 메서드
		setSize(500,500);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("프레임 종료");
				System.exit(0);
			}
		});
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println(e.getX());
				System.out.println(e.getY());
				System.out.println("버튼 눌렀어요. ");
			}
		});
		setVisible(true);
	}
	public static void main(String[] args) {
		new ButtonTest();
	}
	
	
}
