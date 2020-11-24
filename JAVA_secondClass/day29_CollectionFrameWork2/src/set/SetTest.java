package set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("A");
		set.add("O");
		set.add("B");
		set.add("AB");
		set.add("C");
		set.add("A");
		set.add("A");
//		set.add("AA");
		set.add("A");
		set.add("A");
		set.add("A");
		System.out.println("총 수 : " + set.size());
		System.out.println(set);
		
		
		//size는 4다. 왜? set은 중복이 안되니까! A를 아무리 넣어도!
		//이것도 toString을 재정의해서 set만출력해도 나옴 (알파벳순으로 정렬되도록 재정의해놓음)

		//반복자 : Iterator : 반복해서 값을 순서대로 뽑을 때 사용한다.
		//Iterator는 Set에 순서를 부여해준다. (임의대로 순서를 부여함)
		
		//hasNest() : 혹시 그 뒤에 값이 있는지 없는지를 확인함. 
		//값이 있을때만큼 반복하셈! 뒤에 값이 없으면 false가 되서 반복문을 탈출함

		//iter에 다시 넣어줘야iterator() 사용하여 값에 접근할 수 있다. 
		
		
		Iterator<String> iter = set.iterator();
		System.out.println("테스트임");
		System.out.println(iter.next());
		System.out.println(iter.next());
		System.out.println("테스트임");
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
		
		
		
		set.remove("AB");
		System.out.println(set.size());
		System.out.println(set);
		
		set.add("AB");
		System.out.println(set);
		System.out.println(iter.next());
		
		iter = set.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
	}
	
}

