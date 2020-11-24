package day37_FullScreen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FlowLayoutTest extends Frame{
	
	Label label1 = new Label("아니 그래서 뭐머금 ?  ");
	Label label2 = new Label("df");
	Label label3 = new Label("송아지");
	Label label4 = new Label("코끼리");
	
	public FlowLayoutTest() {
		setTitle("FlowLayoutTest");
		setBounds(1200, 300 , 600, 600);
		
		BorderLayout flow = new BorderLayout();
		//BorderLayout => 영역을 나누는 것임. 
		setLayout(flow);
		
		label1.setBackground(Color.PINK);
		//백그라운드색
		label1.setForeground(Color.WHITE);
		//글자색
		label1.setAlignment(Label.CENTER);
		//정렬
		
		Dimension d1 = new Dimension(this.getWidth(), 200);
		
		Font font = new Font("Serif", Font.BOLD, 30);
							//글꼴, 형태, 픽셀
		label1.setFont(font);
		
		label1.setPreferredSize(d1);
		
		add(label1, BorderLayout.SOUTH);
		//할거 다하고 레이블을 붙이는 것임.
		
		//label1을 add하면 붙였으니까 labe2를 이제 만들차례
		
		label2.setBackground(Color.RED);
		label2.setForeground(Color.GREEN);
		label2.setAlignment(Label.CENTER);
		label2.setFont(new Font( "Monospaced", Font.ITALIC,20));
		label2.setPreferredSize(d1);
		
		add(label2, BorderLayout.NORTH);
	
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose ();
			}
		});
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FlowLayoutTest();
	}
	
}
;