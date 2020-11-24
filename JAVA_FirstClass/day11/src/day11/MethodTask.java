package day11;

import javax.swing.JOptionPane;

public class MethodTask {
	// 홀수를 짝수로 짝수는 홀수로 바꿔주는 메서드
	void change(int num1){
		System.out.println("홀수는 짝수로, 짝수는 홀수로 바꾸는 메소드입니다.");
		if(num1 % 2 == 1) {
			num1 ++;
			System.out.println("홀수이므로 1을 더해서 짝수로 만들었습니다.");
			System.out.println(num1);
		}else {
			num1 --;
			System.out.println("짝수이므로 1을 빼서 홀수로 만들었습니다.");
			System.out.println(num1);			
		}
	}
	// 1부터 내가 입력한 정수까지의 누적합을 구해주는 매서드
	void sum(int end) {
		int result = 0;
		if (end > 1) {
			for (int i = 1; i < end+1; i++) {
				result += i;
			}
			System.out.println("1부터 " + end + " 까지의 합을 구하는 매서드 입니다.");
			System.out.println(result);
		} else {
			System.out.println("1보다 큰 수를 입력하세요");
		}
	}
	// 두 정수의 나눗셈 메서드
	void div(int num1, int num2) {
		double result = 0.0;
		if (num2 != 0) {
		result = Double.parseDouble(String.format("%.2f", (double)num1 / num2));
		System.out.println(num1 + " 을 " + num2 + " 로 나누는 메서드입니다." );
		System.out.println(result);
		} else {
			System.out.println("0으로 나눌 수 없습니다.");
		}
	}
	// 정수를 한글로 바꿔주는 메서드
	void chargeToKor(String data){
		String kor = "공일이삼사오육칠팔구";
		String result = "";
		int num  = Integer.parseInt(data);
		for (int i = 0; i < data.length(); i++) {
			result += kor.charAt(num % 10);
			num /= 10;
		}
		for(int i = data.length()-1 ; i > -1 ; i--) {
			System.out.print(result.charAt(i));
		}
	}
	
	
	//main method
	public static void main(String[] args) {
		MethodTask m = new MethodTask();
		int num = 0;
		System.out.println("홀수를 짝수로, 짝수를 홀수로 만들기");
		num = Integer.parseInt(JOptionPane.showInputDialog("숫자를 입력해주세요"));
		m.change(num); 
		
		
		
		
	}
}