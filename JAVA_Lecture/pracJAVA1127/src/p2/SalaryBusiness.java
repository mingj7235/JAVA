package p2;

import java.util.Scanner;

public class SalaryBusiness {
	String serial = null;
	int salary;
	public void input () {
		Scanner sc = new Scanner(System.in);
		System.out.print("급여를 입력해주세요");
		salary = sc.nextInt();
		System.out.print("사번을 입력해주세요");
		serial = sc.next();
	}
	public void check () throws SalaryException,SabunException{
		if (salary <0) {
			throw new SalaryException("급여는 음수가 될 수 없습니다.");
		}if(serial == null) {
			throw new SabunException("사번은 필수 입력입니다.");
		}
	}
}
