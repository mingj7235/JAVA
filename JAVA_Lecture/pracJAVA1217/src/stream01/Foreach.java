package stream01;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Foreach {
	public static void main(String[] args) {
		//반복자
		List <String> list= Arrays.asList("홍길동", "정현희", "김자바");
		
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			String name = iter.next();
			System.out.println(name);
		}
		
		List <String> list2 =Arrays.asList("이순신", "최경미");
		
		Stream <String> stream2 =list2.stream(); //스트림 = 액체, 흘러가는 자료 라고 생각하기
		stream2.forEach(name -> System.out.println(name));
		
		
	}
}
