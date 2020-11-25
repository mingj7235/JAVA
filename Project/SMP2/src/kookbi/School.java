package kookbi;

import javax.swing.JOptionPane;

public class School {
	String [] arMode = {"도서관 관리 모드", "학생 관리 모드", "교사 관리 모드"};
	int choice = 0;
	public void MainView () {
		boolean check = false;
		while (!check) {
			choice = JOptionPane.showOptionDialog(null, "[코리아 IT 아카데미에 오신것을 환영합니다]\n"
					+ "아래의 메뉴를 선택하여 접근할 모드를 선택해주세요", "학생부 관리 Menu", JOptionPane.DEFAULT_OPTION, 
					JOptionPane.PLAIN_MESSAGE, null/*이미지*/, arMode, null);
			if (choice == -1) break;
			switch (choice) {
			case 0 : 
				
				break;
			case 1 : 
				new Managements_Joption().view();;
				break;
			case 2 : 
				
				break;
			
			}
		}
	}
}
