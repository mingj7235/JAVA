package kookbi;

import java.awt.HeadlessException;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class LibraryMagagements_Joption extends StudentManagements_Joption{
	//도서관
	//책을 리스트업하고,
	//빌려간 학생 목록을 검색할 수 있음
	ArrayList<Books> arBooks = new ArrayList<>();
	Books books = null;
	LinkedHashMap<Students, Books> arRentList = new LinkedHashMap<>();
	ImageIcon libraryMainImg = new ImageIcon("src/img/librarymain.gif");
	ImageIcon libraryInsertImg = new ImageIcon("src/img/libraryInsert.gif");
	
	int choice;
	public void libararyView () {
		boolean flag = false;
		String menu [] = {"책 등록", "등록된 책 조회", "책 검색", "책 대여", "대여자 리스트", "메인으로"};
		
		while (!flag) {
			choice = JOptionPane.showOptionDialog(null, "[코리아 IT 아카데미 도서관에 입장하셨습니다.]\n"
					+ "아래의 메뉴를 선택하여 도서관을 관리해주세요", "도서관 관리 Menu", JOptionPane.DEFAULT_OPTION, 
					JOptionPane.PLAIN_MESSAGE, libraryMainImg, menu, null);
			if (choice == -1 || choice == 5) break;
			switch (choice) {
			//책 등록
			case 0 :
				listUp();
				break;
			//등록된 책 전체 조회
			case 1 :
				bookList();
				break;
			//책 검색
			case 2 :
				bookSearch();
				break;
			//책 대여
			case 3 :
				rent();
				break;
			case 4 :
				rentList();
				break;
			case 5 :
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
				String bookName = JOptionPane.showInputDialog("등록할 책 제목을 적어주세요");
				String author = JOptionPane.showInputDialog(bookName + "의 저자를 적어주세요");
				int volume;
				try {
					volume = Integer.parseInt(JOptionPane.showInputDialog(bookName+ "의 페이지수를 적어주세요"));
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "숫자를 입력해주세요");
					break;
					//return하면 어케됨?
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "오류입니다. 다시입력해주세요");
					break;
				}
				books = new Books(bookName, author, volume);
				arBooks.add(books);
				JOptionPane.showMessageDialog(null, bookName + " 책의 정보가 입력되었습니다.");
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
		String result = "";
		if (arBooks.size() == 0) {
			result = "도서관에 등록된 책이 없습니다.";
		} else {
			result += "♡[도서관 소장중인 책 목록]♡\n";
			for (int i = 0; i < arBooks.size(); i++) {
				result += arBooks.get(i) + "\n";
			}
		}
		JOptionPane.showMessageDialog(null, result);
	}
	//책 검색
	public void bookSearch () {
		Iterator<Books> iter = arBooks.iterator();
		String result = "";
		if (arBooks == null) {
			result += "도서관에 등록된 책이 없습니다.";
		}else {
			String bookname = JOptionPane.showInputDialog("♡[책 제목 검색]♡"
				+ "\n검색할 책 제목을 써주세요.\n");
			while (iter.hasNext()) {
				Books temp = iter.next();
				if (bookname.equals(temp.getBookName())) {
					result += "[검색된 자료는 아래와 같습니다.]\n";
					result += temp.toString();
				}
			}
		}
		JOptionPane.showMessageDialog(null, result);
	}
	//책 대여
	public void rent () {
		Iterator<Students> stIter = StudentsBook.keySet().iterator();
		Iterator<Books> bIter = arBooks.iterator();
		String result = "";
		boolean rentCheck = false;
		if (!(StudentsBook.size()==0)) {
			JOptionPane.showMessageDialog(null, "현재 등록된 학생들 입니다");
			list(StudentsBook);
			Integer number = 0;
			try {
				number = Integer.parseInt(JOptionPane.showInputDialog("책을 대여할 학생 학번을 써주세요"));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "숫자로 입력해주세요");
			}
			while (stIter.hasNext()) {
				Students std = stIter.next();
				if(std.getNumber() == number) {
					JOptionPane.showMessageDialog(null, "현재 도서관에 등록된 책 목록을 보여드리겠습니다.");
					bookList();
					String book = JOptionPane.showInputDialog("대여할 책의 제목을 입력해주세요");
					rentCheck = true;
					while (bIter.hasNext()) {
						Books temp = bIter.next();
						if (book.equals(temp.getBookName())) {
							
							arRentList.put(std, books);
							
							JOptionPane.showMessageDialog(null, std.getName() +" 학생에게 "
									+ books.getBookName() +" 책 대여가 완료되었습니다.");
							rentCheck = true;
						}else {
							JOptionPane.showMessageDialog(null, "해당하는 책이 도서관에 없습니다.");
						}
					}
				} else {
					if (number instanceof Integer && !rentCheck) {
						JOptionPane.showMessageDialog(null, "해당 학번의 학생이 없습니다.");
					}
				}
			}
		}else {
			JOptionPane.showMessageDialog(null, "등록된 학생이 없습니다.");
		}
	}
	//책 대여 학생 리스트
	public void rentList () {
		String result = "";
//		result += arRentList.get(std).getBookName();
		JOptionPane.showMessageDialog(null, result);
	}
}




