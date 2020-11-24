package tms;

import javax.swing.JOptionPane;

public class Road {
	
	void view ()	{
		int money = 20000;
		Bus bus360 = new Bus ();
		Subway line2 = new Subway();
		
		String [] arName = {"버스", "지하철"};
		String [] result = new String [2];
		
		while(true) {
			int choice = JOptionPane.showOptionDialog(null, "대중교통을 선택하세요", "TMS", JOptionPane.DEFAULT_OPTION, 
					JOptionPane.PLAIN_MESSAGE, null, arName, null);
			if (choice == -1 ) break;
			
			int btnIndex = JOptionPane.showOptionDialog(null, "도착지를 선택하세요", "TMS", JOptionPane.DEFAULT_OPTION, 
					JOptionPane.PLAIN_MESSAGE, null, bus360.arStation, null);
			
			if (btnIndex == 0 && choice == 0) {
				JOptionPane.showMessageDialog(null, "도착지는 교대를 선택할 수 없습니다.");
				continue;
			}
			if (choice == -1 ) break;
			switch (choice) {
			case 0 :
				result = bus360.go(btnIndex, money).split(", ");
				if (result [0].equals("잔액부족")) {
					JOptionPane.showMessageDialog(null, "잔액이 부족합니다.");
				}else {
					money = Integer.parseInt(result[0]);
					JOptionPane.showMessageDialog(null, "남은 잔액 : " + money + "원 \n" + result[1]);
				}
				break;
			case 1 :
				result = line2.go(btnIndex, money).split(", ");
				if (result [0].equals("잔액부족")) {
					JOptionPane.showMessageDialog(null, "잔액이 부족합니다.");
				}else {
					money = Integer.parseInt(result[0]);
					JOptionPane.showMessageDialog(null, "남은 잔액 : " + money + "원 \n" + result[1]);
				}
				break;
			}
		}
	}
	public static void main(String[] args) {
		new Road().view ();
		//이게 뷰단.
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
