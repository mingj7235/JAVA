package sec06.stream_sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;


public class SortingEx {
	public static void main(String[] args) {
		IntStream intStream = Arrays.stream(new int [] {5,3,2,1,4});
		
		intStream
			.sorted()
			.forEach(n -> System.out.println(n));	//기본적으로 올림차순임
		System.out.println();
		
		//객체요소인경우 (컬렉션을 예로든것임)
		List <Student> studentList = Arrays.asList(
				new Student("홍길동", 30),
				new Student("신용권", 10),
				new Student("유미선", 20)
		);
		
		//기본 정렬 -> Student가 재정의한 방법대로 정렬
		
		studentList.stream()
			.sorted()
			.forEach(s -> System.out.println(s.getScore() + ","));
		//반대 정렬
		studentList.stream()
			.sorted((a,b) -> b.compareTo(a) )
			.forEach(s -> System.out.println(s.getScore() + ","));
		
		studentList.stream()
			.sorted(Comparator.reverseOrder())
			.forEach(s -> System.out.println(s.getScore() + ","));
	}
}
