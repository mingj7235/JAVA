package review;

public class OverLoading {
	/*
	 * 오버로딩
	 * - 같은 이름의 메서드라도 매개변수의 갯수 혹은 타입이 다르면 선언 가능하다. 
	 */
	
	//두정수의 덧셈 메서드
	void add (int num1, int num2){
		int result = 0;
		result = num1 = num2;
		System.out.println(result);
	}
	
	void add (double num1, double num2, double num3) {
		double result = 0.0;
		result = num1 + num2 + num3;
		System.out.println(result);
	}
	
	
	public static void main(String[] args) {
		OverLoading o = new OverLoading()	;
		
		o.add(10, 20);
		o.add(1.3, 2.6, 35.6);
		
		
	}
}
