package p4_anonymous;

public class RemoteControlMain {
	public static void main(String[] args) {
//		RemoteControlRun rtr = new RemoteControlRun();
//		rtr.turnOn();
		
		//익명클래스를 사용하는 방법. 
		//구현객체를 생략하고 바로 사용함
		RemoteControl rtr = new RemoteControl() {
			//익명클래스도 필드를 가질수있다. 하지만 static은 가질 수없다.
			int a = 10;
			
			@Override
			public void turnOn() {
				System.out.println("익명 객체 켜기");
			}
			
			@Override
			public void turnOff() {
				System.out.println("익명객체 끄기");
				ss();
			}
			//익명클래스 자신민의 메소드를 가질 수 있다.
			//하지만, 이 메소드는 외부에서 사용이 불가하고, 익명클래스 내부에서만 사용가능하다. 
			public void ss () {
				System.out.println("익명 객체 자신의 메소드");
			}
		};
		rtr.turnOff();
		//rtr.ss(); 얘는 불가능하다!!!
		
		Searchable sr = new Searchable() {
			int sss = 100;
			@Override
			public void s2() {
				System.out.println("익명객체의 S2메소드");
				cc();
				sss += 10;
			}
			
			@Override
			public void s1() {
				System.out.println("익명객체의 S1메소드");
				cc();
				sss += 10;
				
			}
			void cc () {
				System.out.println("익명클래스 내부에서만 사용하는 메소드");
				sss += 10;
			}
		};
		sr.s1();
		sr.s2();
		
		
	}
}
