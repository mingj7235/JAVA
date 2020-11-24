package day20;

public interface Soldier {
	//인터페이스에서는 상수만 가능. 
	//final static이 생략된것.
	int arms = 2;
	final static int legs = 2;
	
	//인터페이스의 메서드는 모두 abstract 가 생략된것
	void eat ();
	void work ();
	void play ();
	void sleep();
	void salute();
	
	
}
