package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class InputFrame extends JFrame implements ActionListener{
	InputPanel inputPanel = new InputPanel();
	
	public InputFrame() {
		setTitle("강사관리 프로그램"); // setTitle()는 JFrame에서만 쓸 수 있다. JPanel에서는 쓸 수 없다.
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setResizable(false); 
		
		setSize(800, 800);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getSize();
		
		int x = (screenSize.width - frameSize.width)/2;
		int y = (screenSize.height - frameSize.height)/2;
		setLocation(x, y);
		
		add(inputPanel);
		inputPanel.leaveButton.addActionListener(this);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==inputPanel.leaveButton) {
			setVisible(false);
		}
	}
	
}
