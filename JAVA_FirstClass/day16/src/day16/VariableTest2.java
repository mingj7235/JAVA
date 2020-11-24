package day16;

public class VariableTest2 {
	public static void main(String[] args) {
		VariableTest vt = new VariableTest();
		//추상적인 클래스인 VariableTest를 vt로 객체화해서 접근할 수 있게 만드는 것임. 
		//객체화.클래스를 객체로 바꿔준다. 객체화 추상적인 개념을 실제화시킨다.
		
		vt.f();
		vt.f();
		vt.f();
		vt.f();
		
		vt.f2();
		vt = new VariableTest();
		//new를 만나는 순간 초기화 되었기 때문에. 전역변수 data는 다시 0 이된다. 
		//하지만, static을 넣으면 new를 만나도 초기화가 되지 않는다. 
		vt.f();
		
	}
}
