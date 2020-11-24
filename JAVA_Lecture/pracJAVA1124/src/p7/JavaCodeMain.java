package p7;

public class JavaCodeMain {
	public static void main(String[] args) {
		//모든 구현객체를 다형성으로 객체화(인스턴스화) 하기
		
		MyInterface a = new MyClassA();
		MyInterface b = new MyClassB();
		MyInterface c = new MyClassC();
		MyInterface d = new MyInterface() { //인터페이스를 객체화하지 못한다. 익명구현객체로 표현한 것임
		//인터페이스는 new 할수 없다! d는 인터페이스를 객체화한게 아니다. 
		//익명구현객체, 즉 익명클래스를 만든 것이다. 
			@Override
			public void method1() {
				System.out.println("인스턴스의 메소드");
			}
		}; //익명 구현 객체 
		
		a.method1();
		a.method2();
		a.method3();
		System.out.println("======");
		b.method1();
		b.method2();
		b.method3();
		System.out.println("======");
		c.method1();
		c.method2();
		c.method3();
		System.out.println("======");
		d.method1();
		d.method2();
		d.method3();
	}
}
