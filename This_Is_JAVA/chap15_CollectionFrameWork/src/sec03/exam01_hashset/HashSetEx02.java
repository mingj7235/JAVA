package sec03.exam01_hashset;

import java.util.HashSet;
import java.util.Set;

public class HashSetEx02 {
	public static void main(String[] args) {
		Set <Member> set = new HashSet <Member> ();
		
		set.add(new Member("홍길동", 30));
		set.add(new Member("홍길동", 30));
		//new를 사용했기에, 다른 객체다. 하지만, 이름과나이가 같다. (Member클래스에서 equal과 hashcode를 재정의했으므로
		//동등객체다. 그렇기에 set에는 한개만 저장된다.
		
		System.out.println("총 객체수 : " + set.size());
		//객체는 다르지만! 동등객체다! 그렇기에 하나만 저장이 된다. 
	}
}
