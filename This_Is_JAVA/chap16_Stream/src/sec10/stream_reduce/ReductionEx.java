package sec10.stream_reduce;

import java.util.Arrays;
import java.util.List;


public class ReductionEx {
	public static void main(String[] args) {
		List <Student> studentList = Arrays.asList(
				new Student("홍길동", 92),
				new Student("신용권", 95),
				new Student("감자바", 88)
		);
		
		int sum1 = studentList.stream()
				.mapToInt(Student :: getScore)
				.sum();
		
		int sum2 = studentList.stream()
				.mapToInt(Student :: getScore)
				.reduce((a, b) -> a+b) 	//return이 OptionalInt이므로 getAsInt()가 필요함
				.getAsInt();
		
		int sum3 = studentList.stream()
				.mapToInt(Student :: getScore)
				.reduce(0, (a,b) -> a+b);	//identity, 즉 디폴트 값을 0으로 줌. sum2에 비해서 요소가 없을 경우에도 안전함
		
		System.out.println(sum1);
		System.out.println(sum2);
		System.out.println(sum3);
	}
}
