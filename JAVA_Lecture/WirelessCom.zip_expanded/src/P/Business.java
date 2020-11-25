package P;

import java.util.Scanner;

public class Business {
	Scanner sc = new Scanner(System.in);
	Rank rankArr[] = new Rank [10]; //등급배열
	Customer customer[] = new Customer[10]; //고객배열
	int rankCnt = 0, customerCnt = 0;

	public Business() { //생성할 떄 등급 4개 기본 생성
		rankArr[rankCnt++] = new Rank("A", 86, 10000);
		rankArr[rankCnt++] = new Rank("B", 81, 12000);
		rankArr[rankCnt++] = new Rank("C", 104, 15000);
		rankArr[rankCnt++] = new Rank("D", 52, 20000);
	}

	public int mainMenu() {
		System.out.println("--------------메뉴--------------");
		System.out.println("1.입력 2.출력 3.등급추가 4.종료");
		System.out.println("--------------------------------");
		System.out.print("선택 --> ");
		return sc.nextInt();
	}

	public void input() {
		if(customerCnt == 10) {
			System.out.println("고객 수가 이미 최대입니다.");
			return; //메서드 탈출
		}
		System.out.println("--------------입력--------------");
		Rank tmpRank = null; //임시 등급
		System.out.print("고객명: ");
		String name = sc.next();
		System.out.print("등급코드: ");
		String rank = sc.next();
		System.out.print("사용시간: ");
		int time = sc.nextInt();

		for (int i = 0; i < rankCnt; i++) {
			if(rankArr[i].rankName.equals(rank)) { //입력받은 등급이 있을 때
				tmpRank = rankArr[i];
			}
		}
		if(tmpRank == null) {//등급 잘못되었을 때 메서드 탈출
			System.out.println("입력하신 등급이 존재하지 않습니다.");
			return;
		}
		customer[customerCnt++] = new Customer(name, tmpRank, time);
		System.out.println("등록되었습니다.");
	}

	public void output() {
		System.out.println("--------------출력--------------");
		System.out.println("고객명\t등급코드\t시간당단가\t기본요금\t사용시간\t할인요금\t이번달통신요금");
		for (int i = 0; i < customerCnt; i++) {
			Customer cus = customer[i];
			System.out.print(cus.custName+"\t"); //고객명
			System.out.print(cus.gradeCode+"\t\t"); //등급코드
			System.out.print(cus.unitPrice+"\t\t"); //시간당단가
			System.out.print(cus.basePrice+"\t\t"); //기본요금
			System.out.print(cus.useTime+"\t\t"); //사용시간
			System.out.print(cus.discountRate()+"\t\t"); //할인요금
			System.out.print(cus.communicationFee()); //이번달통신요금
			if(i != (customerCnt-1)) System.out.println();
		}
		System.out.println();
	}
	
	public void addRank() {
		System.out.println("---------등급추가---------");
		System.out.print("추가할 등급코드: ");
		String rank = sc.next();
		for (int i = 0; i < rankCnt; i++) { //등급코드 존재하는지 확인
			if(rankArr[i].rankName.equals(rank)) {
				System.out.println("이미 존재하는 등급입니다.");
				return;
			}
		}
		System.out.print("시간당 단가: ");
		int timePrice = sc.nextInt();
		System.out.print("기본요금: ");
		int basicPrice = sc.nextInt();
		rankArr[rankCnt++] = new Rank(rank, timePrice, basicPrice);
		System.out.println("추가되었습니다.");
	}
}
