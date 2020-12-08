package kookbi;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class TeacherManagements_Joption extends LibraryMagagements_Joption{
	
	ImageIcon teacherImg = new ImageIcon("src/img/teacherMain.gif");
	int choice;
	
	public void TeachersView ( ) {
		String menu [] = {"교사 등록", "교사 검색", "교사 삭제", "교사 수정", "교사 조회", "강의실 배정", "메인으로"};
		boolean viewcheck = false;
		while (!viewcheck) {
			choice = JOptionPane.showOptionDialog(null,
					"[코리아 IT 아카데미 교무실 관리 프로그램입니다..]\n" + "아래의 메뉴를 선택하여 교사들을 관리해주세요 :)", "교무실 관리 Menu",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, teacherImg, menu, null);
			if (choice == -1)
				break;
			switch (choice) {
			case 0:
				//교사등록
				teacherInsert();
				break;
			case 1:
				//교사검색
				teacherSearch();
				break;
			case 2:
				//교사삭제
				teacherDelete();
				break;
			case 3:
				//교사수정
				teacherUpdate();
				break;
			case 4:
				//교사조회
				teacherList();
				break;
			case 5:
				//강의실 배정
				assignClass();
				break;
			case 6:
				viewcheck = true;
			}
		}
	}//end view

	public void teacherInsert() {
		
	}//end insert
	
	public void teacherSearch () {
		
		
	}//end search
	
	public void teacherDelete() {
		
	}//end delete
	
	public void teacherUpdate() {
		
	}//end update
	
	public void teacherList () {
		
	}//end list
	
	public void assignClass() {
		
	}//end assign
	


	
	
	
}
