package p1;

public class ExcpetionEx02 {
	public static void main(String[] args) {
		try {
			method1();
		} catch (ArithmeticException e) {
			System.out.println("숫자오류");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 오류");
		}
		method2();
		System.out.println("데이터베이스 종료");
		System.out.println("로그아웃");
	}
	
	private static void method1() /*throws ArithmeticException, ArrayIndexOutOfBoundsException*/{
		a();
	}
	
	private static void a () /*throws /*ArithmeticException, ArrayIndexOutOfBoundsException*/{
		b();
		int [] arr = new int [5];
		arr [5] = 10;
	}
	
	private static void b () /*throws ArithmeticException*/{
		int a = 10;
		int c = a / 2; //예외 발생
	}
	
	private static void method2 () {
		
	}
}
