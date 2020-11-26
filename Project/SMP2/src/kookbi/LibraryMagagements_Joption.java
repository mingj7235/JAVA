package kookbi;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class LibraryMagagements_Joption {
	//도서관
	//책을 리스트업하고,
	//빌려간 학생 목록을 검색할 수 있음
	StudentManagements_Joption sm = new StudentManagements_Joption();
	
	ArrayList<Books> arBooks = null;
	ImageIcon libraryMainImg = new ImageIcon("src/img/librarymain.gif");
	ImageIcon libraryInsertImg = new ImageIcon("src/img/libraryInsert.gif");
	
	int choice;
	
	public void view () {
		boolean flag = false;
		String menu [] = {"책 등록", "책 검색", "책 대여", "대여자 리스트 조회"};
		
		while (!flag) {
			choice = JOptionPane.showOptionDialog(null, "[코리아 IT 아카데미 도서관에 입장하셨습니다.]\n"
					+ "아래의 메뉴를 선택하여 도서관을 관리해주세요", "도서관 관리 Menu", JOptionPane.DEFAULT_OPTION, 
					JOptionPane.PLAIN_MESSAGE, libraryMainImg, menu, null);
			if (choice == -1) break;
			switch (choice) {
			//책 등록
			case 0 :
				listUp();
				break;
			//책 검색
			case 1 :
				bookList();
				break;
			//책 대여
			case 2 :
				rent();
				break;
			//대여자 리스트 조회
			case 3 :
				rentList();
				break;
			}
		}
	}
	
	//책 등록
	public void listUp () {
		boolean LUcheck = false;
		while (!LUcheck) {
			String [] yesOrno = {"YES", "NO"};
			
			choice = JOptionPane.showOptionDialog(null, "♡[책 등록]♡ \n책 등록을 진행하시겠습니까?", "학생부 등록", JOptionPane.DEFAULT_OPTION, 
					JOptionPane.PLAIN_MESSAGE, libraryInsertImg, yesOrno, null);
			if (choice == -1) break;
			
			switch (choice) {
			//책등록 yes
			case 0 :
				
				break;
				
			//책등록 no
			case 1 :
				JOptionPane.showMessageDialog(null, "책 등록을 종료합니다.");
				LUcheck = true;
				break;
			}
		}
	}
	
	//책 리스트
	public void bookList() {
		
	}
	
	//책 대여
	public void rent () {
		
	}
	
	//책 대여 학생 리스트
	public void rentList () {
		
	}
}
