package p8;
//구현 클래스
public class ChildInterEx implements ChildInterfae1{
	@Override
	public void method03() {
		
	}
	@Override
	public void method1() {
		
	}
	
	@Override
	public void method2() {
		System.out.println("메소드 2 재정의");
	}
	
	void ss () {
		ChildInterfae1 ci1 = new ChildInterfae1() {
			@Override
			public void method1() {
				System.out.println("ci1-1");
			}
			@Override
			public void method03() {
				System.out.println("ci1-2");
			}
		};
		ci1.method1();
		ci1.method2();//default 메소드는 오버라이드 하지않아도 바로 사용가능하다. 
		ci1.method03();
	}
}
