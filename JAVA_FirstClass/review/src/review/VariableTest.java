package review;

public class VariableTest {
	//전역 변수
	static int data = 0;
	
	void f () {
		System.out.println(++data);
	}
	
	void f2() {
		data = 20;
	}
}
