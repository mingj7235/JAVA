package sanghwalcoding;

public class Exception {
	
	private int [] arInt = new int [3]	;
	
	Exception () {
		arInt[0] = 0;
		arInt[1] = 10;
		arInt[2] = 20;
	}	
	void div (int num1, int num2) {
		try {
			System.out.println(arInt[num1]/ arInt[num2]);
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 크기가 3을 넘었습니다.");
		} catch (java.lang.Exception e) {
			System.out.println("오류입니다.");
		} finally {
			System.out.println("finally");
		}
	}
	public static void main(String[] args) {
		Exception e = new Exception();
		e.div(10, 2);
		e.div(1, 0);
		e.div(2, 1);
	}
}
