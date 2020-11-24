package review;

import javax.swing.JOptionPane;

/*
 * 홀수를 짝수로 바꿔주는 메서드
 * 1부터 내가 입력한 정수까지의 누적합 구해주는 메서드
 * 두 정수의 나눗셈 메서드
 * 
 * 정수를 한글로 바꿔주는 메서드
 * 입력 예 ) 1024
 * 출력 예 ) 일공이사
 */

public class MethodTask {

	void change (int num) {
		int result = 0 ;
		String msg = "홀수를 짝수로 바꿔주는 메서드 입니다.";
		System.out.println(msg);
		
		if (num / 2 == 0) {
			//짝수라는 말이니까
			System.out.println("짝수" + num + "에 1을 더해 홀수 " + (num + 1) + "로 변경되었습니다.");
			result = num + 1;
			System.out.println(result);
		} else {
			//홀수라는 거니까
			System.out.println("홀수" + num + "에 1을 더해 짝수 " + (num + 1) + "로 변경되었습니다.");
			result = num + 1;
			System.out.println(result);
		}
	}
	
	int sum (int num) {
		String msg = "1부터 내가 입력한 정수까지의 누적합을 구해주는 메서드 입니다.";
		int result = 0;
		
		System.out.println(msg);
		for (int i = 0; i < num + 1; i++) {
			result += i;
		}	return result;
	}
	
	void div (int num1, int num2) {
		String msg = "나눗셈을 해주는 메서드입니다.";
		String errorMsg = "뒤의 숫자는 0보다 커야합니다. ";
		String result = ""; 
		System.out.println(msg);
		
		if (num2 <= 0) {
			System.out.println(errorMsg);
		} else {
			result = String.format("%.2f",(double) num1 / num2); 
		} System.out.println(result);
	}
	
	
	void modiKor (String data) {
		String kor = "영일이삼사오육칠팔구";
		String result = "";
		String fResult ="";
		int num = 0;
		
		num = Integer.parseInt(data);
		for (int i = 0; i < data.length(); i++) {
			result += kor.charAt(num % 10);
			num /= 10;
		}
		for (int i = data.length()-1; i > -1; i--) {
			fResult += result.charAt(i);
			
		}
		JOptionPane.showMessageDialog(null, fResult);			
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		int result = 0;
		MethodTask m = new MethodTask ();
//		m.change(Integer.parseInt(JOptionPane.showInputDialog("정수를 입력해주세요")));
		
//		result = m.sum(Integer.parseInt(JOptionPane.showInputDialog("정수를 입력해주세요")));
//		System.out.println(result);
		
//		m.div(Integer.parseInt(JOptionPane.showInputDialog("첫번째 정수를 입력해주세요")), 
//				Integer.parseInt(JOptionPane.showInputDialog("두번째 정수를 입력해주세요")));
		
		m.modiKor("9088231");
		
//		String test = "김민재";
//		System.out.println(test.charAt(0));
	}
}
