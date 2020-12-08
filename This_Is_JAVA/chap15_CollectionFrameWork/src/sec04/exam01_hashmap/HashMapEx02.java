package sec04.exam01_hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapEx02 {
	public static void main(String[] args) {
		Map <Student, Integer> map = new HashMap<>();
		
		map.put(new Student(1, "홍길동"), 95);
		map.put(new Student(1, "홍길동"), 90);
		//두객체는 분명 다른 것이지만, 학생 no와 이름이 같으므로 (equals와 hashcode 재정의했으니 동등객체로 됨)
		
		System.out.println("총 Entry 수 : " + map.size());
		
		System.out.println(map.get(new Student (1, "홍길동")));
		
	}
}
