package p2;

import java.util.Scanner;

public class SalaryMain {
	public static void main(String[] args) {
		SalaryBusiness sb = new SalaryBusiness();
		sb.input();
		try {
			sb.check();
		} catch (SalaryException e) {
			System.out.println(e.getMessage());
		} catch (SabunException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
