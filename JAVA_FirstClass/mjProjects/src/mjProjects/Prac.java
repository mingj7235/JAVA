package mjProjects;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Prac {
	public static void main(String[] args) {
		
		//day 03 삼항연산자 실습 예제 
		int choice = 0 ;
		
		String qMsg = "3+5는? \n"
				+ "보기\n"
				+ "1. 4\n"
				+ "2. 5\n"
				+ "3. 8\n"
				+ "4. 10\n";
		
		String correctMsg = "정답입니다. ";
		String wrongMsg = "오답 입니다.";
		String errorMsg = "1번에서 4번까지만 눌러주세요.";
		String resultMsg = "";
		int answer1 = 2 ;
		
		choice = Integer.parseInt(JOptionPane.showInputDialog(qMsg));
		
		resultMsg = choice == answer1 ? correctMsg : 
			!(choice < 1 || choice >4) ? wrongMsg : errorMsg;
		
		System.out.println(resultMsg);
		
//		boolean isTrue = 10 > 9;
//		boolean isFalse = 10 < 9;
//		System.out.println(isTrue);
//		System.out.println(isFalse);
//		

				
								
				
				
				
				
				
				
				
				
				
				
//		
//		Scanner sc = new Scanner (System.in);
//		
//		System.out.print("이름 입력 : ");
//		name1 = sc.next();
//		System.out.println("이름 출력 : " + name1);
//		
//		System.out.print("나이 입력 : ");
//		sc.nextLine();
//		age = sc.nextInt();
//		System.out.println("나이출력 : " + age);
//		
		
		
		
		
		
		
		
		
		
		
	}
}
