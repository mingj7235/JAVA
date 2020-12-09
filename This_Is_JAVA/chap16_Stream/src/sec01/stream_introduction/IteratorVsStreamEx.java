package sec01.stream_introduction;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class IteratorVsStreamEx {
	public static void main(String[] args) {
		List <String> list = Arrays.asList("홍길동", "신용권", "감자바");
		
		//Iterator 반복자 이용하는법
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			String name = iter.next();
			System.out.println(name);
		}
		
		//Stream 반복자 이용하는법
		Stream<String>stream = list.stream();
		stream.forEach(name -> System.out.println(name));
		
	}
}
