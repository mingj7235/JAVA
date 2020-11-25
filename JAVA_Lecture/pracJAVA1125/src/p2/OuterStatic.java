package p2;
//static 내부 클래스 예제
public class OuterStatic {
	int ia = 10;
	void iaMethod () {
		//static 내부클래스의 static 필드는 클래스명으로 접근하면 접근이 된다. 
		InnerStatic.iisa =40;
		InnerStatic.iisaMethod();
		System.out.println("이곳은 외부클래스");
	}
	//정적 멤버
	static int isa = 20;
	static void isaMethod () {}
	
	//static 내부클래스
	static class InnerStatic {
		//내부클래스의 인스턴스 멤버
		int iia = 30;
		void iiaMethod () {
			iia = iia -10;
			//외부클래스의 static (정적) 멤버만 사용가능하다. 왜? 내부클래스가 static이므로 먼저 메모리에 올라가므로.
//			ia +=20;
			isa +=20;
		}
		//정적 멤버
		static int iisa = 40;
		static void iisaMethod () {
			//같은 내부클래스 안에 있어도, 인스턴스 멤버인 iia 는 접근할 수 가 없다. 
//			iia = iia-10;
		}
		
		
	}
}
