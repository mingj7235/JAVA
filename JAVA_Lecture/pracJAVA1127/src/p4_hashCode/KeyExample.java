package p4_hashCode;

import java.util.HashMap;

public class KeyExample {
	public static void main(String[] args) {
		//hashmap은 키와 값 두개의 자료를 가지고 있다. 
		//key 하나에 value하나. pair로 가지고 있는 것.
		HashMap<Key, String> hashMap = new HashMap<>();
		hashMap.put(new Key(1), "홍길동");// HashMap이라는 상자안에 자료를 넣기
		String value1 = hashMap.get(new Key(1)); //상자에서 꺼내기 key를 넣으면 value 출력
		System.out.println(value1);
		
		Key k1 = new Key(1);
		Key k2 = new Key(1);
		hashMap.put(k1, "홍길동"); 
		String value2 = hashMap.get(k2); 
		System.out.println(value2);
		
		
	}
}
