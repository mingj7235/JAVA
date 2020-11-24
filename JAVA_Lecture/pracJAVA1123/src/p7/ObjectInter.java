package p7;

public interface ObjectInter {
	//상수
	static final int MAX = 99999;
	static final int MIN = -99999;
	
	//메소드
	
	//추상메소드
	public abstract void calc () ;
	public abstract void avg ();
	
	//디폴트 인스턴트메소드
	default void number () {
		
	}
	
	//정적 메소드
	static void stnumber () {
		
	}
}
