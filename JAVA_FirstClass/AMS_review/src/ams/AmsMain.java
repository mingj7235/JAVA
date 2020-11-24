package ams;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AmsMain {
	public static void main(String[] args) {
		
		//이미지 넣는 방법
		AmsField af = new AmsField();
		//전역변수는 new를 만나는 순간 메모리에서 해제된다
		//static 변수는 프로그램이 종료될 때 메모리에서 해제된다.
		ImageIcon img = new ImageIcon("src/img/main.gif");
		
		String [] menu = {"추가하기", "검색하기", "수정하기", "삭제하기", "목록보기"};
		String [] searchMenu = {"항공사", "항공기번호", "최대승객수", "출발지", "도착지"};
		String [] updateMenu = {"출발지 수정", "도착지 수정"};
		String [] arPlane = new String [5];
		
		int choice = 0;
		int index = 0;
		String keyword = "";
		String planeNum ="";
		String insertMsg = "[추가하실 정보를 그대로 입력하세요] (, 포함)\n"
				+ "항공사, 항공기번호, 최대승객수, 출발지, 도착지";
		String updateMsg = "수정하실 항공기 번호를 입력하세요. \n";
		String deleteMsg = "삭제하실 항공기 번호를 입력하세요. \n";
		
		while (true) {
			choice = JOptionPane.showOptionDialog(null, "", "AMS", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, img, menu, null);
			
			if (choice == -1) break;
			
			switch (choice) {
			
			//추가하기
			case 0 : 
				arPlane = JOptionPane.showInputDialog(insertMsg).split(", ");
				af.insert(arPlane);
				break;
			
			//검색하기
			case 1 : 
				index = JOptionPane.showOptionDialog(null, "", "AMS", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, img, searchMenu, null);
				if (index != -1) {
					keyword = JOptionPane.showInputDialog("검색하실" + searchMenu[index] + "을(를) 입력하세요");
					JOptionPane.showMessageDialog(null, af.search(keyword, index));
				}
				break;
			
			//수정하기	
			case 2 : 
				planeNum = JOptionPane.showInputDialog(updateMsg);
				String temp = af.search(planeNum, 1);
				
				if(temp.equals("검색 결과 없음")) {
					JOptionPane.showMessageDialog(null, "수정실패");
				}else {
					while (true) {
						index = JOptionPane.showOptionDialog(null, "", "AMS", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, img, updateMenu, null);
						if (index == -1 ) {
							JOptionPane.showMessageDialog(null, "취소합니다.");
							break;
						} else {
							String newValue = JOptionPane.showInputDialog("새로운" + updateMenu[index] + "를 입력하세요");
												
							af.update(index, newValue);
							break;
						}
						
					}
				}
				break;
				 
			//삭제하기	
			case 3 : 
				keyword = JOptionPane.showInputDialog(deleteMsg);
				if (af.delete(keyword)) {
					JOptionPane.showMessageDialog(null, "삭제완료");
				}else {
					JOptionPane.showMessageDialog(null, "삭제실패");
				}
				break;
			
			//목록보기	
			case 4 : 
				JOptionPane.showMessageDialog(null, af.show());
				break;
			}
		}
	}
}
