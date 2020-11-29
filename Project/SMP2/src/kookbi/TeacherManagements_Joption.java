package kookbi;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class TeacherManagements_Joption extends LibraryMagagements_Joption{
	
	ImageIcon teacherImg = new ImageIcon("src/img/teacherMain.gif");
	
	
	public void TeachersView ( ) {
		int choice = 0;
		String menu [] = {"교사 등록", "교사 검색", "교사 삭제", "교사 수정", "교사 조회", "강의실 배정", "메인으로"};
		choice = JOptionPane.showOptionDialog(null, "[코리아 IT 아카데미 교무실 관리 프로그램입니다..]\n"
				+ "아래의 메뉴를 선택하여 교사들을 관리해주세요 :)", "교무실 관리 Menu", JOptionPane.DEFAULT_OPTION, 
				JOptionPane.PLAIN_MESSAGE, teacherImg, menu, null);
	}
	
	
	
	
}
