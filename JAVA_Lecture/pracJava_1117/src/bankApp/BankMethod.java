package bankApp;

import java.util.Scanner;

public class BankMethod {
	
	String accountNum;
	String name;
	int balance;
	
	public BankMethod(String accountNum, String name, int balance) {
		this.accountNum = accountNum;
		this.name = name;
		this.balance = balance;
	}
	
	//계좌생성
	void make () {
		Scanner sc = new Scanner(System.in);
		System.out.print("계좌번호 : ");
		accountNum = sc.next();
		System.out.print("계좌주 : ");
		name = sc.next();
		System.out.print("초기입금액 : ");
		balance = sc.nextInt();
		
		System.out.println("계좌가 생성되었습니다.");
	}
	
	//계좌목록
	void list () {
		
	}
	
	void deposit () {
		
	}
	
	void withdraw () {
		
	}
	
	void exit () {
		
	}
	
	
}
