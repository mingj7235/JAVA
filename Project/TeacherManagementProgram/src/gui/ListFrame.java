package gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ListFrame extends JFrame implements ActionListener{

	ListPanel listPanel = new ListPanel();
	
	public ListFrame() {
		
		setTitle("강사관리 프로그램");
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setResizable(false);
		
		setSize(800,800);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getSize();
		
		int x = (screenSize.width - frameSize.width)/2;
		int y = (screenSize.height - frameSize.height)/2;
		
		setLocation(x, y);
		
		add(listPanel);
		listPanel.leaveButton.addActionListener(this);
		
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == listPanel.leaveButton) {
			setVisible(false);
		}
	}
	
}
