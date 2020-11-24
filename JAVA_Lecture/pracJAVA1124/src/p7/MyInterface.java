package p7;

public interface MyInterface {
	void method1(); //2010년 ~ 구현 클래스 공통
	default void method2() {
		System.out.println("2020년도 이후 구현");
	} //2020년도 이후에 구현한 클래스 공통
	//오버라이드 하지 않아도 되는 메서드 사용 가능. 
	//수정에 용이하도록 해놓은 것임. 
	default void method3 () {
		System.out.println("2030년도 이후 구현");
	}//2030년 이후에 구현한 클래스 공통
	
	static void stMethod4 () { //2030년 이후 새로운 메소드
		System.out.println("정적 메소드");
	}
	//default 메소드는 강요하지 않는다. 
	//근데 default로 만든걸, 다시 강제해야할 때는 어떻게해야함?
	//같은 인터페이스를 쓰는데, 2010년 까지 썼던 거는 default니까 강제성이 없음
	//2020년 부터 이 default 메소드를 강제 받아야함.
	//이럴 때는 구현클래스에 default 메소드를 추상메소드로 만들고, 이 클래스를 추상클래스 또는 인터페이스 화 한다. 
	//즉, 디폴트 메소드를 추상 메소드로 재선언한다. 
	
	
}
