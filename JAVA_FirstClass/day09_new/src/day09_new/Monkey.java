package day09_new;

//클래스의 선언
class Human {
	// 필드 - 객체(인스턴스 변수) , 메소드
	// 아래는 예시
	
	// 객체
	int result;
	
	// 메소드
	void add (int num1, int num2) {
		result = num1 + num2;
		System.out.println(result);
	}
}
public class Monkey {
	public static void main(String[] args) {
		Human h = new Human();
		h.result = 20;
		h.add(30, 40);
		
		
	}
}
