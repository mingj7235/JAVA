package p1;

public class Child1 extends Parent{
	int z =10; //자식의 멤버 필드
	void childMethod() {
		//super(10,20); 생성자 호출은 생성자에서만 써줘야 한다. 
		super.x=super.x +20;
		super.y=super.y+30;
		System.out.println("x=" + x + "y=" + y + "z=" + z);
		super.parentMethod();
		//super는 부모의 인스턴스 변수라고 생각하면 된다.
		parentStaticMethod(); //static 이므로 super를 따로 지정해주지않아도 가능
		sx = super.x +super.y;
	}
	
	static void staticChildMethod1 () {
		//static이기때문에, static 은 부모의 변수가 올라가기전에 즉, 인스턴스변수들이
		//아무리 부모꺼여도 그것보다 static이 먼저 올라가기 때문에 뭔지 모른다.
//		super.x = super.x + 20;
//		super.y = super.y + 30;
//		super.sx = super.x + super.y;
//		super.sx =100;
		Parent.sx = 100; //super는 인스턴스이기 때문에 static 변수 sx를 사용하기 위해서는
		//클래스명으로 직접 접촉해야한다.
		Parent.parentStaticMethod();
		//super는 인스턴스다. this는 자식의 인스턴스변수다. super는 부모의 인스턴스변수다. 
		
	}
	
	
	public Child1() {
		System.out.println("자식의 기본 생성자");
	}
	public Child1(int x, int y, int z) {
		//super(); //부모 기본생성자 호출
		//부모의 기본생성자는 자동으로 생략이 된것임.
		//즉, 부모의 기본생성자는 자동으로 올라가기 때문에 super()를 생략해도 상관없음
		super(100, 200);// 부모의 명시적 생성자
		super.x=x;
		super.y=y;
		this.z=z;
		System.out.println("자식의 명시 생성자");
		System.out.println("x=" + x + "y=" + y + "z=" + z);
	}
	static {
		System.out.println("이곳은 자식의 정적 블록입니다.");
	}
	{
		System.out.println("이곳은 자식의 인스턴스 블록입니다.");
	}
	
}
