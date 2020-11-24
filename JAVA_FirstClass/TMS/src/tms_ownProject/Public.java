package tms_ownProject;

import javax.swing.JOptionPane;

public abstract class Public {
	//pay() : 요금을 정산할 수 있는 메서드
	//showDestMsg(String destination) : 도착시 "도착지에 도착했습니다." 메세지 출력하는 메서드
	//자식클래스 : 버스, 지하철
	
	//VIEW
	//이용하실 대중교통을 선택하세요.
	//도착지는 버튼으로 구현 (optionDialog())
	//출발지는 random으로 구현
	//출발지와 도착지가 같지않도록 구현
	//버스는 정방향만 가능
	//지하철은 역방향도 가능
	//교대 > 강남 > 역삼 > 선릉
	
	//변수 선언

			
	abstract void pay (int destIndex, int startIndex);
	
	abstract void showDestMsg (int destIndex);
	
	
	
	
	
		
		
		
	}
	
	

