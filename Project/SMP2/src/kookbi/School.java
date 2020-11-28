package kookbi;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.xml.bind.SchemaOutputResolver;

public class School extends LibraryMagagements_Joption{
	String [] arMode = {"도서관 관리 모드", "학생 관리 모드", "종료하기"};
	int choice = 0;
	ImageIcon schoolImg = new ImageIcon("src/img/School.gif");
	public void MainView () {
		boolean check = false;
		while (!check) {
			choice = JOptionPane.showOptionDialog(null, "[코리아 IT 아카데미에 오신것을 환영합니다]\n"
					+ "아래의 메뉴를 선택하여 접근할 모드를 선택해주세요", "학생부 관리 Menu", JOptionPane.DEFAULT_OPTION, 
					JOptionPane.PLAIN_MESSAGE, schoolImg, arMode, null);
			if (choice == -1 || choice ==2 ) break;
			switch (choice) {
			case 0 : 
				libararyView();
				break;
			case 1 : 
				studentView();
				break;
			case 2 : 
				
				break;
				
			
			}
		}
	}
}
