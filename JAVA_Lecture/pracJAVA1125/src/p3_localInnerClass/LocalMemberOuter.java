package p3_localInnerClass;
//지역 클래스
public class LocalMemberOuter {
	//인스턴스 멤버
	int ia = 10;
	void iaMethod () {
		System.out.println("이곳은 외부클래스");
	}
	//정적 멤버
	static int isa = 20;
	static void isaMethod () {}
	
	void innerMethod() {
		int ii = 19; //자동으로 내부 클래스에 한하여 final 처리됨 그렇기 때문에, 메소드 내 내부클래스에서는 선언된 변수가 변경 불가함
		//메소드 안에 클래스를 넣는다.
		class LocalInner {
			//메소드가 동작할때만 이 클래스가 객체화가 되는 것임
			//클래스 정의
			int inna = 10;
//			ia += 10;
//			isa += 10;
//			ii =20; 변경 불가
			void innaMethod () {
				System.out.println("이곳은 로컬이너클래스입니다.");
				ia += 10;
				//내부클래스를 담고있는 메소드에서 선언된 변수는 사용만 가능하고 변경이불가하다.
				ia = ia + ii; 
				System.out.println(ii);
				
			}
//			static innsa = 20;	//static 필드, 메소드는 못씀 => 인스턴스 메소드 안에 있어서임
//			static innsaMethod () {}
			public LocalInner() { //생성자 가능
			}
		}//end localInner class
		//LocalInner 클래스를 객체화 시켜서 실행하는 코드 작성 !!
		LocalInner li = new LocalInner();
		li.inna += 20;
		li.innaMethod();
		
	}//end innerMethod
}
