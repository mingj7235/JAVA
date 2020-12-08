package kookbi;

import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class TeacherManagements_Joption extends LibraryMagagements_Joption{
	
	ImageIcon teacherImg = new ImageIcon("src/img/teacherMain.gif");
	ImageIcon insertImg = new ImageIcon("src/img/teacherInsert.gif");
	int choice;
	ArrayList<Teachers>arTeachers = new ArrayList<>();
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
		boolean check = false;
		String [] yesOrno = {"YES", "NO"};
		while (!check) {
			choice = JOptionPane.showOptionDialog(null, "♡[강사 등록]♡ \n강사 등록을 진행하시겠습니까?", "강사 등록", 
			JOptionPane.DEFAULT_OPTION, 	JOptionPane.PLAIN_MESSAGE, 
			insertImg, yesOrno, null);
			if (choice == -1) break;
			switch (choice) {
			case 0 :
				String name = JOptionPane.showInputDialog("등록할 강사 이름을 적어주세요") ;
				int age = 0;
				try {
					age = Integer.parseInt(JOptionPane.showInputDialog(name + "강사님의 나이를 입력해주세요"));
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "숫자로 입력해주세요");
				}
				String teachSubject = JOptionPane.showInputDialog(name + "강사님의 담당 과목을 입력해주세요");
				
				Teachers tch = new Teachers(name, age, teachSubject);
				arTeachers.add(tch);
				System.out.println(tch.getTeachName() + " " + tch.getAge() + " " + tch.getTeachSubject());
				break;
				
			case 1 :
				JOptionPane.showMessageDialog(null, "강사 등록을 취소합니다.");
				check = true;
				break;
			}
		}
		
		
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
