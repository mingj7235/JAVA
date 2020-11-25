package p7;

public class ButtonEx {
	
	int a = 20;
	static int sa = 30;
	//기능을 인터페이스로 만들고, 메소드에 넣어서 사용. 
	//클래스 안에 인터페이스를 넣는것임. 
	void aMethod () {
		new OnClickListener() {
			
			@Override
			public void on() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void off() {
				// TODO Auto-generated method stub
				
			}
		};
	}
	static void saMethod () {}
	
	interface OnClickListener {
		default void dMethod () {
//			a += 10; //인스턴스 변수 사용불가
			sa += 20;
//			aMethod (); //인스턴스 메소드사용 불가
			saMethod();
		}
		void off ();
		void on ();
	}
}
