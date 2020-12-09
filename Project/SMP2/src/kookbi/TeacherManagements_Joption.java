package kookbi;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Iterator;

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
				break;
			case 1 :
				JOptionPane.showMessageDialog(null, "강사 등록을 취소합니다.");
				check = true;
				break;
			}
		}
	}//end insert
	
	public void teacherSearch () {
		boolean searchCheck = false;
		Iterator<Teachers> iter = arTeachers.iterator();
		if(arTeachers.isEmpty()) {
			JOptionPane.showMessageDialog(null, "등록된 강사님이 없습니다. \n다시 한번 확인해주세요.");
			return;
		}else {
			String name = JOptionPane.showInputDialog("◆[강사님 검색]◆\n검색하실 강사님 이름을 입력해주세요");
			String result = "";
			while (iter.hasNext()){
				Teachers teacher = iter.next();
				if(name.equals(teacher.getTeachName())) {
					result += teacher.show();
					searchCheck = true;
				}
			}
			if (searchCheck) {
				JOptionPane.showMessageDialog(null, "◆[검색 결과]◆\n  "+ result + "\n");
			}else {
				JOptionPane.showMessageDialog(null, "찾는 강사님이 없습니다.");
			}
		}
	}//end search
	
	public void teacherDelete() {
		int num = 0;
		if(arTeachers.isEmpty()) {
			JOptionPane.showMessageDialog(null, "등록된 강사님이 없습니다. \n다시 한번 확인해주세요.");
			return;
		}
		teacherNumList();
		Teachers delteacher = null;
		try {
		num = Integer.parseInt(JOptionPane.showInputDialog("◆[강사님 정보 삭제]◆"
					+ "\n삭제할 강사님의 사번을 입력해주세요 : "));
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "번호를 입력해주세요");
			return;
		}
		Iterator<Teachers> iter = arTeachers.iterator();
		while (iter.hasNext()) {
			Teachers teacher = iter.next();
			if(num == teacher.getTeachNum()) {
				delteacher = teacher;
			}
		}
		if (delteacher == null) {
			JOptionPane.showMessageDialog(null, "찾는 강사님이 없습니다. \n"
					+ "다시 한번 강사님의 사번을 확인해 주세요.");
		}else {
			arTeachers.remove(delteacher);
			JOptionPane.showMessageDialog(null, "해당 사번의 강사님이 삭제 되었습니다.");
		}
		
	}//end delete
	
	public void teacherUpdate() {
		boolean check = false;
		if (arTeachers.isEmpty()) {
			JOptionPane.showMessageDialog(null, "등록된 강사님이 없습니다.");
			return;
		}
		teacherNumList();;
		int num = 0, choice = 0;
		Iterator<Teachers> iter = arTeachers.iterator();
		while (iter.hasNext()) {
			try {
				num = Integer.parseInt(JOptionPane.showInputDialog("수정할 강사님의 사번을 입력해주세요"));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "사번은 숫자로 입력해주세요");
				return;
			}
			Teachers tch = iter.next();
			if (num == tch.getTeachNum()) {
				check = true;
				JOptionPane.showMessageDialog(null, "[강사님 정보 수정]\n"
						+ "이름, 나이, 담당과목을 순서대로 입력하세요");
				
				tch.setTeachName(JOptionPane.showInputDialog("수정할 강사님 이름을 적어주세요"));
				
				try {
					tch.setAge(Integer.parseInt(JOptionPane.showInputDialog("변경될 " + tch.getTeachName() + " 강사님의 나이를 적어주세요")));
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "숫자로 적어주세요.");
					break;
				}
				tch.setTeachSubject(JOptionPane.showInputDialog(tch.getTeachName() + " 강사님의 변경된 담당 과목을 적어주세요"));
				
				JOptionPane.showMessageDialog(null, "강사님 정보 수정 완료");
				teacherList();
				break;
			}
		}
		if (!check){
			JOptionPane.showMessageDialog(null, "강사님 사번을 다시 확인해주세요 ");
		}
	}//end update
	
	public void teacherList () {
		Iterator<Teachers> iter = arTeachers.iterator();
		if (arTeachers.isEmpty()) {
			JOptionPane.showMessageDialog(null, "등록된 강사님이 없습니다. \n다시 한번 확인해주세요.");
			return;
		}else {
			String result = "◆[코리아 IT 아카데미 강사님들]◆\n";
			while (iter.hasNext()) {
				Teachers teachers =iter.next();
				result += teachers.show() + "\n";
			}
			JOptionPane.showMessageDialog(null, result);
		}
	}//end list
	
	public void teacherNumList () {
		Iterator<Teachers> iter = arTeachers.iterator();
		if (arTeachers.isEmpty()) {
			return;
		}else {
			String result = "◆[코리아 IT 아카데미 강사님들]◆\n";
			while (iter.hasNext()) {
				Teachers teachers =iter.next();
				result += teachers.showNum() + "\n";
			}
			JOptionPane.showMessageDialog(null, result);
		}
	}//end list
	
	
	public void assignClass() {
		
	}//end assign
	


	
	
	
}
