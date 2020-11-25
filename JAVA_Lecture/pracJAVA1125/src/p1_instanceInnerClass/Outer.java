package p1_instanceInnerClass;
//인스턴스 내부 클래스 예제
public class Outer {
	//인스턴스 멤버
	int ia = 10;
	void iaMethod () {
		//내부 클래스 멤버는 사용 불가
		
		System.out.println("이곳은 외부클래스");
	}
	//정적 멤버
	static int isa = 20;
	static void isaMethod () {}
	
	class Inner {
		//내부클래스의 멤버
		int iia = 30;
		void iiaMethod () {
			System.out.println("이곳은 내부클래스");
		}
		//내부클래스에서는 인스턴스 멤버만 선언 가능하다.
//		static int iisa = 40;
//		static void iisaMethod () {} //내부 클래스에는  static을 쓸 수 없다. 
		
		//외부 클래스 멤버 사용 => 이 이유때문에 중첩 클래스를 사용 하는 것임.
		//제약 없이 외부 클래스의 멤버들을 사용할 수 있음. 
		//예 ) 외부 윈도우화면 내부 버튼 클래스
		void iiaMethod2 () {
			ia += 30;
			iaMethod ();
			isaMethod();
		}
		
		
	}
}
