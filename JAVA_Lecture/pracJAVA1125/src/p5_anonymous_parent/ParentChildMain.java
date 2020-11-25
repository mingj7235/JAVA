package p5_anonymous_parent;
public class ParentChildMain {
	public static void main(String[] args) {
		//일반적인 방법
//		Child c1 = new Child();
//		Child2 c2 = new Child2();
//		c1.p1();
//		c2.p2();
		int a = 20;
		//추상클래스의 부모를 익명 자식 객체로 만든 예제
		//추상 클래스를 객체화 했더니 추상메소드가 오버라이드하도록 자동으로나온다. 
		Parent p1 = new Parent() {
			int b =20;
			
			@Override
			public void ap1() {
				System.out.println("익명 자식 객체 추상 메소드");
				ss();
				b = a+b;
			}
			public void ss () {
				System.out.println("익명 자식만 사용가능한 메소드");
			}
		};
		p1.p1();
		p1.ap1();
		//일반 클래스의 부모를 익명 자식 객체로 만들기
		Parent2 p2 = new Parent2() {
			@Override
			public void p2() {
				// TODO Auto-generated method stub
				super.p2();
			}
			void cc () {
				System.out.println("음?");
			}
		}; //;을 주면 익명클래스라는 의미임. 생성자에 세미클론을 줌. 
		p2.p2();
		
	}
}






