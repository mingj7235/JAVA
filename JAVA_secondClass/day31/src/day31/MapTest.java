package day31;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		//과일
		HashMap<String, Integer> fruitMap = new HashMap<>();
		Collection<Integer> price = null;
		ArrayList<Integer> arPrice = new ArrayList<>();
		int total = 0;
		double avg = 0.0;
		
			//put 메서드 : 값을 넣는것
		fruitMap.put("사과", 1000);
		fruitMap.put("배", 2000);
		fruitMap.put("자두", 3000);
		fruitMap.put("수박", 4000);
		
		System.out.println(fruitMap.get("자두") + "원");
		System.out.println(fruitMap.keySet());
		System.out.println(fruitMap.values());
		
		price = fruitMap.values();
		
		
		System.out.println(price + "콜렉션");
		
//		for (int i : price) {
//			System.out.println(i + "원");
//			//collection은 순서를 가지고있기때문에, for문을 사용해서 값을 도출할 수있다. 
//		}
		//람다식
		
		price.forEach(data -> arPrice.add(data));
		System.out.println(arPrice);
		
		Set<Entry<String, Integer>> set = fruitMap.entrySet();
		//Entry는 두개를 던져줘야한다. 키, 벨류. 
		//entry -> '입력' 이라는 의미가 있다. 그대로 입력하는 것. hashMap을 한 쌍으로 그대로 입력!!!
		//key 따로, value따로가아니라 한 쌍으로 그대로 들어감.
		//한 쌍이 입력이된다. 
		//set 타입이 된다. 
		Iterator<Entry<String, Integer>> iter = set.iterator();
		//set에서는 순서가없기때문에 Iterator를 해줘야 set에 순서가 부여되고, 값에 접근할 수 있다. 
		
		while (iter.hasNext()) {
			Map.Entry<String, Integer> e = iter.next();
			//iter.next() 반환값이 쌍이기때문에 (Entry 타입) Entry 타입의 e로 담아준다. 
			System.out.println("과일 이름 : " + e.getKey() + ", 가격 : " + e.getValue() + "원");
			total += e.getValue();
		}
		avg =Double.parseDouble(String.format("%.2f", (double) total/ fruitMap.size()));
		
		System.out.println("과일 평균 가격 : "  + avg + "원");
	}
}
