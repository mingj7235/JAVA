package testPractice;

import java.util.Scanner;

public class School {
	Scanner sc = new Scanner(System.in);
	Students [][] studentbook = new Students [3][5]; //maximum 과목수가 5개
	int choice = 0;
	int eleStd = 0, midStd = 0, highStd = 0;
	
	public void view () {
		System.out.println("학생의 grade를 확인해주세요"
				+ "\n1. 초등학생"
				+ "\n2. 중학생"
				+ "\n3. 고등학생");
		choice = sc.nextInt();
		switch(choice) {
		case 1 : 
			input();
			break;
		case 2 : 
			input();
			break;
		case 3 : 
			input();
			break;
		default :
			break;
		}
	}
	
	public void input () {
		Elementary ele = new Elementary();
		System.out.println("과목을 입력해주세요");
		ele.subject = sc.next();
		System.out.println("중간고사 점수를 입력해주세요");
		ele.midterm = sc.nextInt();
		System.out.println("기말고사 점수를 입력해주세요");
		ele.finalterm = sc.nextInt();
		System.out.println("수행평가 점수를 입력해주세요");
		ele.exp = sc.nextInt();
		ele.total();
		if (choice == 1) { //초딩
			studentbook [choice-1][eleStd++] = ele;
		}else { //중딩
			Middle mid = (Middle) ele;
			System.out.println("출석점수를 입력해주세요");
			mid.attend = sc.nextInt();
			System.out.println("봉사점수를 입력해주세요");
			mid.volunteer = sc.nextInt();
			if (choice ==2) {
				studentbook [choice-1][midStd++] = mid;
			}else { //고딩
				High high = (High) mid;
				high.avg();
			}
		}
	}
	
	public void output () {
		switch (choice) {
		case 1 : 
			
			break;
		case 2 : 
			
			break;
		case 3 : 
			
			break;
		default :
			break;
		}
	}
	
}
