package Q11;

public class IntegerCompare {
	public static void main(String[] args) {
		Integer obj1 = 100;
		Integer obj2 = 100;
		Integer obj3 = 300;
		Integer obj4 = 300;
		
		System.out.println(obj1 == obj2);//true
		
		System.out.println(obj3 == obj4);//false
		
		/*
		 * 이유 : Integer 타입에서 값의 범위가 -128~127이면 ==은 값을 비교함
		 * 그외에는 번지를 비교하기 때문이다. (Boxing된 범위가 이렇게된다.)
		 * 그래서 대부분은 값을 비교할때 equals를 사용하는 것이 좋음
		 */
	}
}
