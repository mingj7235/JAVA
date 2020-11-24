package day20_abstractClass;

public interface Soldier {
	final static int arm = 2;
	int legs = 2;
	
	public abstract void eat ();
	void work ();
	void play ();
	void sleep ();
	void salute ();
}
//변수를 선언하면 무조건 final static이 생략되어있다. 외부에서 수정 절대 불가.
//사용만 가능하다. 
//인터페이스에서 메소드를 선언하면 무조건 public abstract가 생략되어있다. 
