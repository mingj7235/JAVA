package p4;
//자식 클래스
public class AA extends B {
	
	@Override
	void bMethod1() {
		y = x * 2;
	}
	
	void aaMethod () {
		y+=20;
		//x+=20; //부모 클래스에서 final로 선언된 변수이기때문에 변경불가!
		System.out.println(x + 20);
		//변경은 불가해도 사용하는 것은 가능함.
		
	}
}
