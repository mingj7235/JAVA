package review;

import javax.swing.JOptionPane;

public class CalTest {
	public static void main(String[] args) {
		MethodTask c = new MethodTask();
		String mResult = "";
		
		mResult = JOptionPane.showInputDialog("한글로변환시킬 숫자입력");
		c.modiKor(mResult);
	}
}

