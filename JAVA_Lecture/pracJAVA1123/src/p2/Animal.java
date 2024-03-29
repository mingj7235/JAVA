package p2;
//부모클래스
public abstract class Animal {
	public String kind;
	public void breathe () {
		System.out.println("숨을 쉽니다.");
	}
	public abstract void sound (); // 추상메소드 -> 각 동물마다 울음소리가 다르므로. 자식들이 구현하도록 만드는것임
	
	//추상클래스는 일반클래스에 추상메소드가 더해진 것이므로, 일반 클래스에서
	//허용된것은 모두 가능하다. 
	//실행순서 : static {} --> main () --> { } --> 생성자
	
	public Animal() {
	}
	//생성자 가능
	static {
		//정적 초기화 블록 가능
	}
	
	{
		//초기화 블록 가능
	}
	
}
