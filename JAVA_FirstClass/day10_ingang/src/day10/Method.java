package day10;

public class Method {
	
	int add(int num1, int num2) {
		System.out.println("add 메소드 입니다.");
		return num1 + num2;
	}
	
	public static void main(String[] args) {
	//class 안에 메소드를 선언해줘야 컴파일러가 안다. 그래서 선언해주는 것이다. 
	Method m = new Method();
	int result = 0;
	result = m.add(3, 8);
	System.out.println(result);
	
	}
}
