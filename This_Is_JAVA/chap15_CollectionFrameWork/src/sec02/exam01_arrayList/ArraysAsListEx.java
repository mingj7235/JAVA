package sec02.exam01_arrayList;

import java.util.Arrays;
import java.util.List;

public class ArraysAsListEx {
	public static void main(String[] args) {
		//객체가 고정되어 있을 경우 이렇게 사용하는게 간편함
		List <String> list1 = Arrays.asList("홍길동", "신용권", "감자바");
		for (String name : list1) {
			System.out.println(name);
		}
		
		List <Integer> list2 = Arrays.asList(1, 2, 3);
//		List <Integer> list2 = Arrays.asList(new Integer(1), new Integer(2), new Integer(3));
		//이게 정석이지만 귀찮음. 자동 박싱을 이용하잣
		for (int num : list2) {
			System.out.println(num);
		}
		
	}
}
