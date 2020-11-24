package day08_new;

public class MethodTest {
	public static void main(String[] args) {
		MethodTest m = new MethodTest();
		System.out.println(m.sum(13, 24));
		
		
	}
	int sum (int num1, int num2) {
		System.out.println("더하기 메소드 입니다.");
		int result = num1 + num2;
		return result;
	}
	
	
	
	
}
