package p1_instanceInnerClass;

public class OuterMain {
	public static void main(String[] args) {
		//내부클래스를 main에서 사용하기 위해서는
		//1. 외부클래스를 객체화
		Outer outer = new Outer();
		outer.ia += 20;
		outer.iaMethod();
		outer.isa += 40;
		outer.isaMethod();
		
		//내부클래스의 멤버들은 외부 클래스의 참조변수로 접근 못함
		// outer.iia =100;
		
		//2. 내부클래스를 객체화해야한다.
		Outer.Inner oi = outer.new Inner();
		
		oi.iia = 40;
		oi.iiaMethod();
		//접근가능
		
	}
}
