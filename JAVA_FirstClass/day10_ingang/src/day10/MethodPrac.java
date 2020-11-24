package day10;

import java.util.concurrent.SynchronousQueue;

public class MethodPrac {
	int add (int num1, int num2){
		System.out.println("덧셈 메서드 연습.");
		return num1 + num2;
	}
	
	int multi (int num1, int num2) {
		System.out.println("곱셈 메서드 연습.");
		return num1 * num2;
	}

	public static void main(String[] args) {
		// int result = add (1, 5);
		// 안되는 이유. main 메서드에 static (컴파일 하자마자 이 메서드를 가장 먼저 실행해라! 라는 명령) 이 붙어있기 때문에
		// 컴파일러는 메서드 중 main 부터 실행을 한다. 그래서 add 메서드선언을 인식 못한채 main 에 있는 add (1,5);를 실행못하는 것.
		// 컴파일러 : add 메서드가뭐야..? 왜냐면 main 부터 인식하니까. 
		// 그래서 1번째 방법 : int 메서드에 static을 붙여준다.
		MethodPrac m = new MethodPrac();
		// 2번째 방법 : add 메서드의 소속을 말해준다. MethodPrac이라는 클래스 안에 있다. => main 메서드에서 선언을 해줘야한다.
		int result_add = m.add(5, 7);
		int result_multi = m.multi(6 ,8);
		//Scanner 선언할때처럼. 와.......개쩐다. Scanner sc = new Scanner(System.in); 했던것처럼...sc.next(); 했던 것처럼..
		System.out.println(result_add);
		System.out.println(result_multi);
	
	}			
}

