package examJAVA1126;

import java.util.Scanner;

public class Business {
	Scanner sc = new Scanner(System.in);
	int choice = 0;
	int area = 0, time = 0, weight = 0;
	Locations arData [] = new Locations [10];
	int cnt = 0;
	
	public void view () {
		boolean flag = false;
		while (!flag) {
			System.out.println("=======================");
			System.out.println("배달 현황 프로그램");
			System.out.println("=======================");
			System.out.println("프로그래머 : 김민재");
			
			System.out.print("1. 입력 2. 출력 3. 종료"
					+ "\n선택 ==> ");
			choice = sc.nextInt();
			
			switch (choice) {
			case 1 : 
				insert ();
				break;
			case 2 : 
				print();
				break;
			case 3 : 
				System.out.println("프로그램을 종료합니다.");
				flag = true;
				break;
			}
		}
	}
	
	public void insert () {
		System.out.println("=======================");
		System.out.println("입력화면 입니다.");
		System.out.println("=======================");
		
		System.out.print("배달 지구\n"
				+ "(1. 강동지구, 2. 강서지구 3. 강남지구 4. 강북지구) 선택 : ");
		area = sc.nextInt();
		
		System.out.print("배달 시간 :");
		time = sc.nextInt();
		
		System.out.print("배달량 갯수 : ");
		weight = sc.nextInt();
		
		switch (area) {
		case 1 : 
			arData[cnt] = new Kangdong("강동지구", "장동욱", time, weight);
			cnt++;
			break;
		case 2 : 
			arData[cnt] = new Kangseo("강서지구", "박영수", time, weight);
			cnt++;
			break;
		case 3 : 
			arData[cnt] = new Kangnam("강남지구", "이기영", time, weight);
			cnt++;
			break;
		case 4 : 
			arData[cnt] = new Kangbuk("강북지구", "김찬영", time, weight);
			cnt++;
			break;
		}
	}
	
	public void print () {
		System.out.println("=======================");
		System.out.println("출력화면 입니다.");
		System.out.println("=======================");
		System.out.print("메뉴를 선택해주세요"
				+ "\n1. 지구별로 2.모든지구 3. 종료"
				+ "\n선택 : ");
		
		choice = sc.nextInt();
		switch (choice) {
		//지구별 출력
		case 1 :
			System.out.print("출력 원하는 지구 (1. 강동지구, 2. 강서지구 3. 강남지구 4. 강북지구) :");
			choice = sc.nextInt();
			switch (choice) {
			//강동지구
			case 1: 
				System.out.println("=======");
				System.out.println("강동지구");
				System.out.println("=======");
				System.out.println("배달담당  배달시간  배달량  배달요금");
				for (int i = 0; i < arData.length; i++) {
					if (arData[i] == null) {
						break;
					}
					if(arData[i].area.equals("강동지구")) {
						System.out.println(arData[i].deliever + " " + arData[i].time + " " + arData[i].weight + " " + arData[i].totalPayCal());
					}else {
					}
				}
				break;
			//강서지구
			case 2: 
				System.out.println("=======");
				System.out.println("강서지구");
				System.out.println("=======");
				System.out.println("배달담당  배달시간  배달량  배달요금");
				for (int i = 0; i < arData.length; i++) {
					if (arData[i] == null) {
						break;
					}
					if(arData[i].area.equals("강서지구")) {
						System.out.println(arData[i].deliever + " " + arData[i].time + " " + arData[i].weight + " " + arData[i].totalPayCal());
					}else {
					}
				}
				
				break;
			//강남지구
			case 3: 
				System.out.println("=======");
				System.out.println("강남지구");
				System.out.println("=======");
				System.out.println("배달담당  배달시간  배달량  배달요금");
				for (int i = 0; i < arData.length; i++) {
					if (arData[i] == null) {
						break;
					}
					if(arData[i].area.equals("강남지구")) {
						System.out.println(arData[i].deliever + " " + arData[i].time + " " + arData[i].weight + " " + arData[i].totalPayCal());
					}else {
					}
				}
				break;
			//강북지구
			case 4: 
				System.out.println("=======");
				System.out.println("강북지구");
				System.out.println("=======");
				System.out.println("배달담당  배달시간  배달량  배달요금");
				for (int i = 0; i < arData.length; i++) {
					if (arData[i] == null) {
						break;
					}
					if(arData[i].area.equals("강북지구")) {
						System.out.println(arData[i].deliever + " " + arData[i].time + " " + arData[i].weight + " " + arData[i].totalPayCal());
					}else {
					}
				}
				break;
			}
			
			
			break;
		//모든지구 출력
		case 2 :
			System.out.println("=======");
			System.out.println("모든지구");
			System.out.println("=======");
			System.out.println("배달담당  배달시간  배달량  배달요금");
			for (int i = 0; i < arData.length; i++) {
				if (arData[i] == null) {
					break;
				} else {
					System.out.println(arData[i].deliever + " " + arData[i].time + " " + arData[i].weight + " " + arData[i].totalPayCal());
				}
				
			}
			break;
		case 3 :
			
			break;
		}
		
	}
	
}
