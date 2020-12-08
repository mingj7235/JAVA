package sec05.exam02_treeMap;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapEx01 {
	public static void main(String[] args) {
		TreeMap<Integer, String> scores = new TreeMap<> ();
		scores.put(87, "홍길동");
		scores.put(98, "이동수");
		scores.put(75, "박길순");
		scores.put(95, "신용권");
		scores.put(80, "김자바");
		
		//이진트리로 저장될 때 key를 기준으로 저장됨
		
		Map.Entry<Integer, String> entry = null;
		
		entry = scores.firstEntry();
		System.out.println("가장 낮은 점수 : " + entry.getKey() + "-" +entry.getValue() + "\n");
		
		entry = scores.lastEntry();
		System.out.println("가장 높은 점수 : " + entry.getKey() + "-" +entry.getValue() + "\n");
		
		entry = scores.lowerEntry(95);
		System.out.println("95점 아래점수 : " + entry.getKey() + "-" +entry.getValue() + "\n");
		
		entry = scores.higherEntry(95);
		System.out.println("95점 위의 점수 : " + entry.getKey() + "-" +entry.getValue() + "\n");
		
	}
}
