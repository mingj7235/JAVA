package p1;

import java.util.Scanner;

public class BankApplicationMain {
	Scanner sc = new Scanner(System.in); //전역변수로 사용
	// => 2군데의 메소드에서 공통으로 이용하기 위해서
	BankApplication [] bankAddress = new BankApplication[10];
	static int cnt = 0;
	public BankApplicationMain(int arrayLe) {
		bankAddress = new BankApplication[arrayLe];
	}
	public static void main(String[] args) {
		BankApplicationMain ba = new BankApplicationMain(10);
		int choice;
		boolean flag = true;
		while(flag) {
			ba.headTitle();
			choice = ba.inputChoice();
			switch (choice) {
			case 1 : 
				ba.createBank();
				break;
			case 2 : 
				ba.display();
				break;
			case 3 : 
				ba.deposit();
				break;
			case 4 : 
				ba.withdraw();
				break;
			case 5 : 
				flag = false;
				break;
			}
		}
	}
	
	void deposit() {
		System.out.println("____________________");
		System.out.println("예   금");
		System.out.println("____________________");
		System.out.print("계좌번호");
		String inputbankNumber ;
		inputbankNumber = sc.next();
		//해당 계좌 찾기
		boolean searchOk = false;
		for (int i = 0; i < cnt; i++) {
			if (inputbankNumber.equals(bankAddress[i].getBankNumber())) {
				System.out.print("예금액 : ");
				int money = sc.nextInt();
				bankAddress[i].setMoney(money + bankAddress[i].getMoney());
				searchOk = true;
			}
		}
		if (searchOk) System.out.println("결과 : 예금이 성공했습니다.");
		else System.out.println("결과 : 계좌번호가 틀립니다.");
	}

	void withdraw() {
		System.out.println("____________________");
		System.out.println("출   금");
		System.out.println("____________________");
		System.out.print("계좌번호");
		String inputbankNumber ;
		inputbankNumber = sc.next();
		
		for (int i = 0; i < cnt; i++) {
			if (inputbankNumber.equals(bankAddress[i].getBankNumber())) {
				System.out.print("출금액 : ");
				int money = sc.nextInt();
				if (money > bankAddress[i].getMoney()) {
					System.out.println("금액이 부족합니다.");
				}else {
					bankAddress[i].setMoney(bankAddress[i].getMoney() - money);
					System.out.println("출금이 완료되었습니다.");
				}
			}
		}
	}
	void display() {
		System.out.println("____________________");
		System.out.println("계좌 목록");
		System.out.println("____________________");
		for (int i = 0; i < cnt; i++) {
			System.out.print(bankAddress [i].getBankNumber()+ "   ");
			System.out.print(bankAddress [i].getBankName()+ "   ");
			System.out.print(bankAddress [i].getMoney()+ "   ");
			System.out.println();
		}
	}

	void createBank() {
		cnt++;
		int i = cnt-1;
		bankAddress [i] = new BankApplication();
		System.out.println("-------------");
		System.out.println("계좌생성");
		System.out.println("-------------");
		System.out.print("계좌 번호 : ");
		bankAddress [i].setBankNumber(sc.next());
		System.out.print("계좌주 : ");
		bankAddress [i].setBankName(sc.next());
		System.out.print("초기 입금액 :");
		bankAddress [i].setMoney(sc.nextInt());
		System.out.println("계좌가 생성되었습니다.");
	}

	//메뉴 출력하는 메소드
	void headTitle () {
		System.out.println("-------------------------------------------------------");
		System.out.println("1.계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
		System.out.println("-------------------------------------------------------");
		System.out.println("선택>");
	}
	
	//입력 받는 메소드
	int inputChoice () {
		int choice = sc.nextInt();
		return choice;
	}
}
