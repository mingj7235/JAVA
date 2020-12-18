package p02;

import java.util.Arrays;
import java.util.stream.Stream;

public class FromArrayEx {
	public static void main(String[] args) {
		String [] strArray = {"홍길동", "신용권", "김미나"};
		
		//배열에서 스트림 얻기
		Stream <String> strStream = Arrays.stream(strArray);
		//중간스트림
		strStream.forEach(m -> System.out.println(m));
		
//		strStream.forEach(m -> System.out.println(m)); //스트림은 한번 흘려보내면 끝남 두번하면안댐
		
		
		Stream.of(strArray).forEach(m ->System.out.println(m));
		
		Double [] doubleArr = { 1.1, 2.2, 3.3};
		Arrays.stream(doubleArr).forEach(d ->System.out.println(d));
		long count = Stream.of(doubleArr).count();
		System.out.println(count);
	}
}
