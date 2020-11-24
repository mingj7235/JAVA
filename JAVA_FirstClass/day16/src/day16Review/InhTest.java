package day16Review;

class A {
	int data = 10;
	
	public A() {
		System.out.println("부모 클래스 생성자");
	}
	
	void show ()	 {
		System.out.println("A클래스");
	}
}

class B extends A{
	
	@Override
	//재정의 
	void show() {
		System.out.println("B클래스");
	}
	
	void check ()	{
		show();
	}
	
}

public class InhTest {
	public static void main(String[] args) {
		B instance = new B ()	;
		//B(); 에는 부모 생성자를 호출하는 super()가 들어가 있다. 
		instance.check();
	
	}
	
}
