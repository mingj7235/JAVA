package p1;

public class Parent {
	int x;
	int y;
	
	static int sx;
	static void parentStaticMethod () {
		System.out.println("부모의 정적 메소드");
	}
	
	void parentMethod () {
		System.out.println("x=" + x + "y=" + y);
	}
	
	public Parent() {
		System.out.println("부모 기본 생성자");
	}
	public Parent(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("부모 명시 생성자");
		parentMethod();
	}
	static {
		System.out.println("이곳은 부모의 정적 블록입니다.");
	}
	{
		System.out.println("이곳은 부모의 인스턴스 블록입니다.");
	}
}
