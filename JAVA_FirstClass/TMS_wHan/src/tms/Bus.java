package tms;

import java.util.Random;

import javax.swing.JOptionPane;

public class Bus extends Public{
	int fee = 1200;
	
	@Override
	int pay(int money) {
		money -= fee;
		return money;
	}
	
	@Override
	String go(int btnIndex, int money) {
		//출발지와 도착지가 같은지 확인해주고
		//정방향인지 역방향인지를 생각해서 for문을 돌아야 한다.
		//btnIndex =  도착지
		//index = 출발지		
		int cnt = 0;
		int index = 0;
		String result = "";
		
		Random r = new Random ();
		
		while (true) {
			index = r.nextInt(arStation.length);
			if (btnIndex > index) break;
		}
		cnt = btnIndex - index;	
		
		if (money - fee < 0) {
			result = "잔액부족,";
		}else {
			result = "" + pay(money) + ", ";
			//형변환 ""
			result += arStation[index] + " > "; 
			for (int i = 0; i < cnt ; i++) {
				result += i == cnt -1 ? arStation[index + i + 1] : arStation[index + i + 1] + " > ";  
			}
			showDestMsg (arStation[btnIndex]);
		}
		return result ; 
	}
	
	
	@Override
	void showDestMsg(String destination) {
		JOptionPane.showMessageDialog(null, destination + "에 도착했습니다.");
	}

}
