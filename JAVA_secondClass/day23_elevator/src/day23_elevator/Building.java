package day23_elevator;

import java.util.Random;
import java.util.Scanner;

public class Building {
	public static void main(String[] args) {
		Elevator e = new Elevator();
		Random r= new Random();
		int cnt = 0;
		int floor = 0;
		String check = "";
		//엘레베이터 정원
		int [] arElevator = new int [5];
		
		//인원수를 랜덤으로 할 것임. 0명 ~ 5명 
		cnt = r.nextInt(6);
		for (int i = 0; i < cnt; i++) {
			arElevator [i] = 1;
		}
		
		while (true) {
			//최대 : 10층
			//최소 : -3층
			//0까지 포함하면 14층이 있는것. 
			floor = r.nextInt(e.maxFloor + (e.minFloor*-1)+1) + e.minFloor;
			//e.minFloor*-1 해주는 이유는 양수를 담아야해서다. 
			//r.nextInt안에는 14가 들어가야 0~13이 나온다. 
			//0~13에 -3 을 하면  -3 ~10 이 나온다. (랜덤은 0부터 담기기 때문에 0부터 생각을 해야한다) 
			if (floor != 0) break; 
			//0이 아닐때 끝남.
			//while문으로 계속 반복할 수 있도록 하는건 0일경우에 계속 반복돌도록하는것임
			}
		if (cnt == 0) {
			System.out.println("현재 탑승 인원 : 없음 (최대5명)");
		} else {
			System.out.println("현재 탑승 인원 : " +cnt + "명 (최대5명)");
		}
		System.out.println("Y : 타기               N : 보내기");
		check = new Scanner(System.in).next().toUpperCase();
		//사용자가 y와n을 소문자로 입력할 수있을지 모르므로 toUpperCase() 메서드를 사용하여 뭐든지 대문자로 입력받도록함.
		if(check.equals("Y")) {
			cnt++;
			try {
				arElevator[cnt-1] =1 ;
				Elevator.floor = floor;
				e.go();
			} catch (Exception e1) {
				System.out.println("정원초과");
			}
		}
		
		
		
		
		
		
		
		
	}
}
