package day05_new;

import java.util.Scanner;

public class LectureReview {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		String msg = "1. 통신요금 조회\n2. 분실신고\n3. 단말기 대금납부\n0. 상담원 연결";
		
		do {
			System.out.println(msg);
			choice = sc.nextInt();
		
		}while (choice != 0);
		
//while (choice ! =0); 일경우 조건식이 int choice=0 으로 선언되었으므로 이미 조건식이 0이되어 false가 되어서 탈출됨. 그래서 do 씀
	
	}
}

