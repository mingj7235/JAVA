package p2;

import p2.OuterStatic.InnerStatic;

public class OuterStaticMain {
	public static void main(String[] args) {
		//static 내부 클래스는 외부클래스를 객체화 하지 않아도, 접근 할 수 있다.
		
		//1. 외부클래스의 객체화 상관없이 객체화 시킬 수 있다. (외부클래스에서 접근만 시키는 것임.) 
//		OuterStatic.InnerStatic oi = new OuterStatic.InnerStatic();
		InnerStatic oi = new InnerStatic(); //import를 하면 이렇게도 가능함.
		oi.iia = 300;
		oi.iiaMethod();
		oi.iisa = 200;
		oi.iisaMethod();
		
		//new를 한 이유는 인스턴스 멤버들을 heap에 올리기 위해서다.
		//oi로 객체화 안하고 바로
		//OuterStatic.InnerStatic.iia 이런식으로 접근해도되지만,
		//이렇게 하면 static 내부클래스에 있는 인스턴스 멤버들이 heap에 올라가지 않기 때문에,
		//new를 하여 객체화를 시켜주는 것이다. 
		
	}
}
