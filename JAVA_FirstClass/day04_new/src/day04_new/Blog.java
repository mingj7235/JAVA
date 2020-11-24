package day04_new;

import java.util.Scanner;

public class Blog {
	public static void main(String[] args) {
		//혈액형 별 성격 테스트
		String msg = "Q. 당신의 혈액형은? ";
		String cMsg = "1. A \n2. B \n3. O \n4. AB";
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		
		String a_msg = "꼼꼼하고 세심하다.";
		String b_msg = "추진력이 있다.";
		String o_msg = "사교성이 좋다.";
		String ab_msg = "착하다.";
		String result_msg = ""; 
		
		System.out.println(msg + "\n" + cMsg);
		choice = sc.nextInt();
		
		switch (choice) {
		case 1 : 
			result_msg = a_msg;
			break;
		case 2 :
			result_msg = b_msg;
			break;
		case 3 :
			result_msg = o_msg;
			break;
		case 4 :
			result_msg = ab_msg;
			break;
		default : 
			result_msg = "?";
		}
		System.out.println(result_msg);
		//break를 쓰는 이유. switch는 아래로 쭉 읽는다. 그래서 반드시 break를 넣어야한다. 
	}
}
		
		

