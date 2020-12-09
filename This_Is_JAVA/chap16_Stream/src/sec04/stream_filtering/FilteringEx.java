package sec04.stream_filtering;

import java.util.Arrays;
import java.util.List;

public class FilteringEx {
	public static void main(String[] args) {
		List <String> names = Arrays.asList("홍길동", "신용권", "김자바", "신용권", "신민철");
		
		//중복 제거
		names.stream()		//오리지널 스트림
		.distinct()					//중복 제거 중간 스트림
		.forEach(n -> System.out.println(n)); 	//최종스트림 forEach
		
		System.out.println();

		//필터링
		names.stream()
		.filter(n -> n.startsWith("신"))	//starsWith : String 클래스의 메소드. 매개값으로 시작하는 문자열이있으면 true를 리턴함
		.forEach(System.out :: println);
		
		System.out.println();
		
		//중복 제거 후, 필터링 하기 
		names.stream().distinct().filter(n -> n.startsWith("신")).forEach(System.out :: print );
		
		
	}
}
