package p6;

public class Outer {
	int o1 = 10;
	void o1Method () {}
	class Inner {
		int i1 = 20;
		int o1 = 30; //외부클래스와 내부 클래스가 어쨌든 다른 클래스이므로,  같은이름의 변수 선언이 가능
		void i1Method () {
			//여기서 this는 inner클래스의 주소다. 
			System.out.println(this.o1); //30
			System.out.println(o1); //30
			System.out.println(new Outer().o1); //10
			System.out.println(Outer.this.o1); //10
		}
	}
}
