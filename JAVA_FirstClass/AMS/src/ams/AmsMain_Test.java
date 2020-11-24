package ams;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class AmsMain_Test {
	public static void main(String[] args) {
		AmsField af = new AmsField ();
		AmsPlain_Info info = new AmsPlain_Info();
		AmsPlainMethod apm = new AmsPlainMethod();
		
		ImageIcon img = new ImageIcon("src/img/main.gif");
		
		String [] arPlane = new String [5];
		String keyword = "";
		String [] menu = {"추가하기", "검색하기", "수정하기", "삭제하기", "목록보기"};
		String [] insertPlainMenu = {"대한항공", "아시아나항공", "제주항공", "이스타항공"};
		String [] searchMenu = {"항공사", "항공기 번호 ", "최대 승객수", "출발지", "도착지"};
		String [] updateMenu = {"출발지 수정", "도착지 수정"};
		
		int choice = 0;
		int index = 0;
		
		String insertMsg = "[추가하실 정보를 그대로 입력하세요 (, 포함)] \n"
				+ "항공사, 항공기번호, 최대승객수, 출발지, 도착지";
		String deleteMsg = "삭제하실 항공기 번호를 입력하세요.\n";
		String updateMsg = "수정하실 항공기 번호를 입력하세요\n";
		
		while (true) {
			choice = JOptionPane.showOptionDialog(null, "", "AMS", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, img, menu, null);
		
			if (choice == -1) break;
			
			switch (choice) {
			
			//추가하기 영역
			case 0 : 
				int companyIndex = 0;
				
				companyIndex = JOptionPane.showOptionDialog(null, "", "AMS_Insert", JOptionPane.DEFAULT_OPTION, 
						JOptionPane.PLAIN_MESSAGE, img, insertPlainMenu, null);
				while (true) {
					if (companyIndex == -1) break;
					
					switch (companyIndex) {
					case 0 : 
						apm.korAirInfo();
						break;
					case 1 : 
						
						break;
					case 2 : 
						
						break;
					case 3 : 
						
						break;
						
					}
					
				}
					
					break;
					
					
					
				
			//검색하기 영역	
			case 1 :
				index = JOptionPane.showOptionDialog(null, "", "AMS", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, img, searchMenu, null);
				if (index != -1)	{
					keyword = JOptionPane.showInputDialog("검색하실 " + searchMenu[index] + "을(를) 입력하세요");
					JOptionPane.showMessageDialog(null, af.search(keyword, index));
				}
				break;
				

			case 2 : 
				String planeNum = JOptionPane.showInputDialog(updateMsg);
				String temp = af.search(planeNum, 1);
				
				if(choice == -1) break;
				if(temp.equals("검색 결과 없음")) {
						JOptionPane.showMessageDialog(null, "수정 실패");
					}else {
						index = JOptionPane.showOptionDialog(null, "", "AMS", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, img, updateMenu, null);
						String newValue = JOptionPane.showInputDialog("새로운"+ updateMenu[index] + "를 입력하세요");
						af.update(index, newValue);
					}
				break;
				
			//삭제하기 영역
			case 3 :
				keyword = JOptionPane.showInputDialog(deleteMsg);
				if(af.delete(keyword)) {
					JOptionPane.showMessageDialog (null, "삭제 완료");
				}else {
					JOptionPane.showMessageDialog (null, "삭제 실패");
				}
				break;
				
			//목록보기 영역
			case 4 :
				JOptionPane.showMessageDialog(null, af.show());
				//af.show() 자체가 return 타입이 String 이므로 JOptionPane에 바로 넣는다.
				break;
			}
			
		}
		
		
	
	
}
}
