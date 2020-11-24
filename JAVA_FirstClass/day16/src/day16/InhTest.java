package day16;

class A {
	int data = 10;
	
	//기본생성자
	public A() {
		System.out.println("부모 클래스 생성자");
		//확인용 syso
	}
	
	void show () 	{
		System.out.println("A 클래스");
	}
	
}

class B extends A {
	
	public B() {
		System.out.println("자식 클래스 생성자");
	}
	
	@Override
	void show() {
		super.show();
		System.out.println("B클래스");
	}
	//재정의(override)
	
	void check ()	{
		//A클래스의 show() 메소드를 가져왔다. 
		show();
	}
	
}

public class InhTest {
	public static void main(String[] args) {
		B instance = new B (); 
		instance.check();
		//자식 생성자를 사용하면 부모클래스를 호출한다.
		//부모클래스를 호출하는 Super()가 자동으로 있는것이다.  
		
	}
	
	
}
