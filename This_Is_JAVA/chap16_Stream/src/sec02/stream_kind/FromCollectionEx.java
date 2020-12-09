package sec02.stream_kind;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FromCollectionEx {
	public static void main(String[] args) {
		List <Student> studentList = Arrays.asList(
			new Student("홍길동", 10),
			new Student("신용권", 20),
			new Student("유미선", 30)
		);
		
		Stream<Student> stream = studentList.stream();
		stream.forEach(s -> System.out.println(s.getName()));
		//함수적 인터페이스를 가진 forEach 
		
	}
}
