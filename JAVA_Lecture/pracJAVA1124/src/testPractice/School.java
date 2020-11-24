package testPractice;

import java.util.Scanner;

public class School {
	Scanner sc = new Scanner(System.in);
	Elementary elementary = new Elementary();
	Middle middle = new Middle();
	High high = new High();
	
	
	public void view () {
		
	}
	
	public void check (Students std) {
		if (std instanceof Elementary) {
			elementary();
		}
	}
	
	public void elementary () {
		
	}
	
	
}
