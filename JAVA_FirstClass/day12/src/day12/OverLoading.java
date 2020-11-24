package day12;

public class OverLoading {
	
	void add (int num1, int num2 ) {
		System.out.println("두 정수의 합");
		System.out.println(num1 + num2);
	}
	void add (int num1, int num2, int num3 ) {
		System.out.println("세 정수의 합");
		System.out.println(num1 + num2 + num3);
	}
	void add (double num1, double num2 ) {
		System.out.println("두 실수의 합");
		System.out.println(num1 + num2);
	}
	
	void add (String data) {
		System.out.println(data);
	}
	
	public static void main(String[] args) {
		OverLoading o = new OverLoading();
		o.add(10, 20);
		o.add(10.5, 20.9);
		o.add(1, 2, 3);
		// 근데 3개의 정수의 덧셈을 하고 싶어
		// 이럴때 method를 또 만들어야함?
		// ㄴㄴ 오버로딩 이용해서 매개변수가 달라도 같은 메서드를 사용할 수 있다. (add, add2,add3 .... 이렇게 만들필요없다.)
		// (매개변수의 갯수, 타입이 달라도 가능... 개간지네)
		
		
	}
}
