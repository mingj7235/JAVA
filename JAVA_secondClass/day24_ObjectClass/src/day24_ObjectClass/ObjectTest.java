package day24_ObjectClass;

import java.util.Random;

public class ObjectTest {
	//항상 모든 클래스는 Object를 상속받는다
	public static void main(String[] args) {
		/*
		 * equals()는 두 주소값이 같은지 확인하는 메서드다. 
		 */
		//String은 클래스이기 때문에 객체화가 가능하다. 
		//주소값으로 직접 들어가서 값을 가지고오기때문에 data1,2 를 참조변수로고도한다.
		
		String data1 = new String("ABC");
		String data2 = new String("ABC");
		System.out.println(data1 == data2);
		
		
		//이게 왜 false인가? 
		//== : 좌측의 주소값과 우측의 주소값이 같은지를 비교하는 주소값 비교 연산자다. 
		//그러므로 data1과 data2의 주소값이 다르기 때문에 false이다. 
		
		System.out.println(data1.equals(data2));
		
		
		//이건 어떻게 true가 나오는가? ==과 마찬가지로 주소값을 비교하는데?
		//data1.equals()의 equals는 String 클래스에 있는 메서드다.
		//Object 클래스에 있는 equals() 메서드를 String에서 재정의되어 주소값이 아닌 값을 비교하기 위해 재정의됨
		//그렇기 때문에 값을 비교하게 되는 것이다. 
		//String 타입은 주소값을 저장한다. 왜냐하면 객체이기 때문이다. 
		//intern() 이라는 메서드는 값이 같은 것을 String의 pool에서 찾음.
		//그래서 그것을 리턴해줌. 
	
		String data3 = "ABC";
		String data4 = "ABC";
		System.out.println(data3 == data4);
		
		//얘네는 intern()을 쓰든 안쓰든 똑같은 이유.
		//기존에 있던 값들이 중복이 되지 않기 때문에 똑같이 "ABC"라고 이미 만들었기 때문에 
		//data3과 data4는 같을 수 밖에 없다. 새롭게 "ABC"를 또 만들수 없기 때문이다. 
		//똑같은 주소값을 공유한다. 
		
		System.out.println(data3.equals(data4));
		System.out.println(data3.intern() == data4);
		//equals를 못쓰고 ==를 써야할수밖에 없는 경우는 .intern()을 써서 값이 같다면 true를 출력할 수 있다. 
		//String끼리 비교할 때는 .equals로 비교하는 것이 안전하다. 
		
		System.out.println("RANDOM==============");
		Random r = new Random();
		Random r2 =new Random();
		
		System.out.println(r.equals(r2));
		System.out.println(r == r2);
		//여기에서 사용한 equals() 는 Object 메소드에 있는 것이므로 주소값을 비교한다. 
		//그러므로 r과 r2의 주소값은 다르므로 출력값은 false가 나온다. 
		
		r=r2;
		//이렇게 하면 똑같아짐. 
		System.out.println(r.equals(r2));
		System.out.println(r == r2);
		
		//hashcode
		System.out.println(data1.hashCode());
		System.out.println(data2.hashCode());
		System.out.println(data3.hashCode());
		System.out.println(data4.hashCode());
		//4개의 hashcode가 모두 같다. 
		//data1~4ㅇ에 담긴 값이 모두 같기 때문에 hashcode는 모두 같다. 
		//왜냐하면 data1, data2 다른 heap 메모리에 있지만 (data3와 data4는 stack. 공유함)
		//값 자체는 같기때문에 hashcode가 모두 같다. 
		
		
		System.out.println(data1.hashCode() == data2.hashCode());
		System.out.println(data1 == data2); 
		System.out.println(data3.hashCode() == data2.hashCode());
		// 이 값은 true가 나온다. 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
				
	}
}
