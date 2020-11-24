package tms_ownProject;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class TMS_Main {

	
	public static void main(String[] args) {
		int tmsIndex;
		int busStartIndex;
		int busDestIndex;
		int subDestIndex;
		Bus b = new Bus ();
		Random startR = new Random ();
		Random destR = new Random ();
		
		ImageIcon img = new ImageIcon("src/img/bus.gif");
		
		final String [] tmsChoice = {"BUS", "SUBWAY"};
		final String [] busStart = {
				"주공아파트", "현대아파트앞", "동사무소앞", "성심병원", "보라매공원", "성남중학교", "숭의여고", "노선도보기"	
		};
		
		final String [] busDestination = {
				"주공아파트", "현대아파트앞", "동사무소앞", "성심병원", "보라매공원", "성남중학교", "숭의여고", "노선도보기"
		};
		
		final String [] subwayStart = {
				"대방역", "노량진역", "용산역", "남영역", "서울역", "시청", "종각", "종로3가", "종로5가", "동대문", "노선도보기"
		};
		
		final String [] subwayDestination = {
			"대방역", "노량진역", "용산역", "남영역", "서울역", "시청", "종각", "종로3가", "종로5가", "동대문", "노선도보기"
		};
		
		String errMsg = "출발지와 목적지가 같습니다. 다시 확인해주세요";
		String startMsg = "";
		
		//Bus
		
		while (true) {
			
			tmsIndex = JOptionPane.showOptionDialog(null, "TMS", "BUS or SUBWAY", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, img, tmsChoice, null);
			
			if (tmsIndex == -1) break;
			if (tmsIndex == 0) {
				
				busDestIndex = JOptionPane.showOptionDialog(null, "도착지를 선택해주세요", "TMS", JOptionPane.DEFAULT_OPTION, 
						JOptionPane.PLAIN_MESSAGE, img, busDestination, null);
				if (busDestIndex == -1) break;
				switch (busDestIndex) {
				
				case 0 : 
					busStartIndex = startR.nextInt(6);
					startMsg = "현재 당신의 출발지는 " + busStart[busStartIndex] + "입니다";
					
					JOptionPane.showMessageDialog(null, startMsg);
					if (busStartIndex == busDestIndex) {
						JOptionPane.showMessageDialog(null, errMsg);
						break;
					} else {
						b.pay(busDestIndex, busStartIndex);
						
					}break;
					
				case 1 :
					busStartIndex = startR.nextInt(6);
					startMsg = "현재 당신의 출발지는 " + busStart[busStartIndex] + "입니다";
					
					JOptionPane.showMessageDialog(null, startMsg);
					if (busStartIndex == busDestIndex) {
						JOptionPane.showMessageDialog(null, errMsg);
						break;
					} else {
						b.pay(busDestIndex, busStartIndex);
						
					}break;
					
				case 2 : 
					
					
				case 3 : 
					
					
				case 4 : 
					
					break;
					
				case 5 : 
					
					
					
				case 6 : 
					
				case 7 : 
					
					break;
					
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	
}

