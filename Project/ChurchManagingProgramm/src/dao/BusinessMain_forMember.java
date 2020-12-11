package dao;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class BusinessMain_forMember {
	static Font myFont = new Font ("Lucida Bright", Font.PLAIN, 15);
	
	
	public void view () {
		UIManager.put("OptionPane.messageFont", myFont);		
		JOptionPane.showMessageDialog(null, "");
	
		
		
		
		
		
	}
}
