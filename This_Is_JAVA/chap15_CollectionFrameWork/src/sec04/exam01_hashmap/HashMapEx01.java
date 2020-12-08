package sec04.exam01_hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx01 {
	public static void main(String[] args) {
		Map <String, Integer> map = new HashMap<String, Integer>();
		
		map.put("신용권", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		map.put("홍길동", 95);
		//키가 같으면 중복 저장이 되지 않는다. 
		
		System.out.println("총 Entry 수 : "+ map.size());
		System.out.println("홍길동 : " + map.get("홍길동"));
		//이전의 값은 다음 값으로 변경됨
		System.out.println();
		
		Set<String>keySet = map.keySet(); //key들만 뽑아서 저장함 set타입으로 저장함
		
		Iterator <String> keyIterator = keySet.iterator(); //key의 반복자 얻기
		while (keyIterator.hasNext()) {
			String key = keyIterator.next();
			Integer value = map.get(key);
			System.out.println("\t" + key + " : " + value);
		}
		System.out.println();
		
		map.remove("홍길동");
		System.out.println("총 Entry 수 : "+ map.size());
		System.out.println("홍길동 : " + map.get("홍길동"));
		
		Set <Map.Entry<String, Integer>> entrySet = map.entrySet();
		Iterator <Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
		while(entryIterator.hasNext()) {
			Map.Entry<String, Integer> entry = entryIterator.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("\t" + key + " : " + value);
		}
		System.out.println();
		
		map.clear();
		System.out.println("총 Entry 수 : "+ map.size());
		
		
		
		
	}
}
