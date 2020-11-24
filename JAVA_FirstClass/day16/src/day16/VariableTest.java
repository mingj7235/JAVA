package day16;

public class VariableTest {
	// 전역변수 
	int data = 0;
	
	void f() {
		System.out.println(++data);
	}
	
	void f2() {
		data = 20;
	}
}
