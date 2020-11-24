package tms_ownProject;

import javax.swing.JOptionPane;

public class Bus extends Public {
	TMS_Main t = new TMS_Main ();
	@Override
	void pay(int destIndex, int startIndex) {
		
		int payMoney = 500 * Math.abs(destIndex - startIndex);
		String payMsg = "교통비는 " + payMoney +" 원 입니다.\n"
				+ "(교통비는 한 정거장 마다 500원이 추가됩니다.)";
		
		
		JOptionPane.showMessageDialog(null, payMsg);
	}

	@Override
	void showDestMsg(int destIndex) {
		JOptionPane.showMessageDialog(null, "고객님 " + destIndex + " 에 도착하셨습니다.");
				
			}
		
	void bus () {
		
	}
	
	
	
}	


