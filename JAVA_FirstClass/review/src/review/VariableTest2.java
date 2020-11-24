package review;

public class VariableTest2 {
	public static void main(String[] args) {
		VariableTest vt = new VariableTest();
		System.out.println(vt.data);
		vt.f();
		vt.f();
		vt.f();
		vt.f();
		vt.f();
		vt.f2();
		vt = new VariableTest();
		//다시 초기화하는거임 다시 들어가서 다시 초기화. ㅇㅋ;
		vt.f();
		//static을 넣으면 초기화가 안됨. 
		//전역변수와 static 변수의 차이. 
		vt.f();
	}
}
