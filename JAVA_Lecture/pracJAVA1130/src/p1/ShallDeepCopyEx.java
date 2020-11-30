package p1;

public class ShallDeepCopyEx {
	public static void main(String[] args) {
		Circle c1 = new Circle(new Point(1, 1), 2.0);
		Circle c2 = c1.shallowCopy(); //얕은복사
		Circle c3 = c1.deepCopy();//깊은복사
		
		System.out.println("c1 = " + c1);
		System.out.println("c2 = " + c2);
		System.out.println("c3 = " + c3);
		
		//값을 수정
		c1.p.x = 9;
		c1.p.y = 10;
		c1.r =30; //기본형이기 때문에 값이 복사가 되므로 원본이 변하여도 바뀌지 않는다. (복제가 된것이므로)
						//즉, 원본과 복사본은 다른 공간을 가진다.
						//하지만, 얕은복사에서 객체형은 같은 공간을 가지므로 복사된다. 
						//객체까지 모두 복사하고 싶다면, 깊은 복사를 해야한다. 
		Circle c4 = c1.deepCopy();// 다시 깊은복사
		
		System.out.println("값 수정 후 ");
		System.out.println("c1 = " + c1);
		System.out.println("c2 = " + c2);
		System.out.println("c3 = " + c3);
		System.out.println("c4 = " + c4);
		
	}
}
