package tms;

import java.util.Random;

import javax.swing.JOptionPane;

public class Subway extends Public{
	int fee = 1200;
	
	
	@Override
	int pay(int money) {
		money -= fee;
		return money;
	}
	
	@Override
	String go(int btnIndex, int money) {
		int cnt = 0;
		int index = 0;
		String result = "";
		
		Random r = new Random ();
		
		while (true) {
			index = r.nextInt(arStation.length);
			if (btnIndex != index) break;
		}
		cnt = btnIndex - index;	
		
		if (money - fee < 0) {
			result = "잔액부족,";
		}else {
			result = "" + pay(money) + ", ";
			//형변환 ""
			result += arStation[index] + " > "; 
			if (cnt > 0) {
				for (int i = 0; i < cnt ; i++) {
					result += i == cnt -1 ? arStation[index + i + 1] : arStation[index + i + 1] + " > ";  
				}
				showDestMsg (arStation[btnIndex]);
			}else {
				cnt *= -1;
				for (int i = 0; i < cnt ; i++) {
					//index : 출발지
					result += i == cnt -1 ? arStation[index - i - 1] : arStation[index - i - 1] + " > ";  
				}
				showDestMsg (arStation[btnIndex]);
			}
		}
		return result ; 
	}
	
	
	@Override
	void showDestMsg(String destination) {
		JOptionPane.showMessageDialog(null, destination + "에 도착했습니다.");
	}

}
