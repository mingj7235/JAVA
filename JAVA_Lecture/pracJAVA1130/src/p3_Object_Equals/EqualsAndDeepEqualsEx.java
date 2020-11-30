package p3_Object_Equals;

import java.util.Objects;

public class EqualsAndDeepEqualsEx {
	public static void main(String[] args) {
		Integer o1 = null; //정수형 클래스 o1 -> 참조변수
		Integer o2 = null;
//		System.out.println(o1.equals(o2));	 //Object클래스의 메소드
//		System.out.println(o1.equals(null));
//		System.out.println(null.equals(o2));	//Object클래스의 equals 메소드에서는 이렇게 못쓴다.
//		System.out.println(null.equals(null)); //null값과 비교를 할 수 가없음 그래스 Objects 클래스가 나온것임
		System.out.println("Objects클래스 활용");
		System.out.println(Objects.equals(o1, o2)); //o1.equals(o2)와 같은것임
		System.out.println(Objects.equals(o1, null));  
		System.out.println(Objects.equals(null, o2));//일반 객체값이 null일때 null값과 비교 가능
		System.out.println(Objects.equals(null, null));
		
		System.out.println("\ndeepEquals 메소드");
		Integer [] arr1 = {1,2};
		Integer [] arr2 = {1,2};
		Integer [] arr3 = {1,2,3};
		
		//deepEquals 메소드는 객체의 요소를 비교하는 클래스임. 오...이거 활용 크겠다. 
		System.out.println(Objects.deepEquals(arr1, arr2));
		System.out.println(Objects.deepEquals(arr1, arr3));
		
	}
}
