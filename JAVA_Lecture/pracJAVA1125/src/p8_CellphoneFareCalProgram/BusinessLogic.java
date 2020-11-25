package p8_CellphoneFareCalProgram;

import java.util.Scanner;

public class BusinessLogic {
	AGrade ag = null;
	BGrade bg = null;
	CGrade cg = null;
	DGrade dg = null;
	//모든 구현 객체를 객체화 시키기
	public BusinessLogic() {
		ag = new AGrade();
		bg = new BGrade();
		cg = new CGrade();
		dg = new DGrade();
	}
	
	Scanner sc = new Scanner(System.in);
	void start ( ) {
		menuDisplay(); //메뉴 보이게 하기
	}
	
	void menuDisplay () {
		boolean flag = true;
		int choice =0;
		while (flag) {
			System.out.println("------------------------");
			System.out.println("1. 입력 2. 출력 3. 종료");
			System.out.println("------------------------");
			System.out.print("선택 : ");
			choice = sc.nextInt();
			switch (choice) {
			case 1: input ();break;
			case 2: /*output ()*/; break;
			case 3 : flag =false; break;
			}
		}
	}//end menuDisplay()
	
	void input () {
		System.out.print("고객명 : ");
		String customer =  sc.next();
		System.out.print("등급 : ");
		String grade = sc.next();
		System.out.print("사용시간 : ");
		int useTime = sc.nextInt();
		
		switch (grade) {
		case "A" :
		case "a" : ag.aInput(customer, grade, useTime); break;
		case "B" :
		case "b" :
		case "C" :
		case "c" :
		case "D" :
		case "d" :
		}
		
	}
	
	void output() {
		
	}
	
	
	
}
