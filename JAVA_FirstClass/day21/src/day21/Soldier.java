package day21;

public interface Soldier {
	//상수(변하지 않는 수), 추상메서드 만 선언이 가능하다.
	final static int arm = 2;
	int legs = 2;
	
	public abstract void eat ();
	void work();
	//바디가 없는 메서드 = 추상메서드.
	//abstract가 없는 이유 = 생략!!
	void play();
	void sleep();
	void salute();
	
}
