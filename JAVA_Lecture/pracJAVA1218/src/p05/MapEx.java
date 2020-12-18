package p05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MapEx {
	public static void main(String[] args) {
		int [] intArray = {1,2,3,4,5};
		IntStream intStream = Arrays.stream(intArray);
		
		intStream.asDoubleStream().forEach(n -> System.out.println(n));
		
		intStream = Arrays.stream(intArray);
		intStream.boxed().forEach(n -> System.out.println(n.intValue()));
		
		
		
		List <Student> studentList = Arrays.asList( 
				new Student("홍길동", 10),
				new Student("신용권", 20),
				new Student("유미선", 30)
				);
		
		studentList.stream()
					.mapToInt(Student :: getScore)
					.forEach(s -> System.out.println(s));
	}
}
class Student {
	private String name;
	private int score;
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
	
	}