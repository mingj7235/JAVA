package dao;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class BusinessMain_forMember {
	static Font myFont = new Font ("휴먼편지체", Font.PLAIN, 15);
	int choice = 0;
	
	public void view () {
		boolean viewFlag = false;
		String [] menu = {"회원 등록", "회원 수정", "회원 삭제", "출석관리"};
		UIManager.put("OptionPane.messageFont", myFont);		
		while (!viewFlag) {
			choice = JOptionPane.showOptionDialog(null, "[청년부 회원 관리 프로그램]\n"
					+ "아래 메뉴를 선택해주세요", "청년부 회원 관리 프로그램", JOptionPane.DEFAULT_OPTION, 
					JOptionPane.PLAIN_MESSAGE, null, menu, null);
			if (choice == -1) break;
			switch (choice) {
			case 0 : 
				register();
				break;
			case 1 :
				update ();
				break;
			case 2: 
				delete ();
				break;
			case 3 :
				attend ();
				break;
			}
		}
	}
	//청년부 회원 등록
	public void register () {
		
	}
	//회원 수정
	public void update () {
		
	}
	//회원 삭제
	public void delete () {
		
	}
	//출석 관리
	public void attend () {
		
	}
	
}
