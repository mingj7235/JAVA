package p01;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class MapAndReduceEx {
	public static void main(String[] args) {
		List <Student> list =Arrays.asList(
				new Student ("홍길동", 10),
				new Student ("신용권", 20),
				new Student ("유미선", 30)
				);
		
		OptionalDouble avg1 = list.stream().mapToInt(Student :: getScore).average();
		double avg2 = list.stream().mapToInt(Student :: getScore).average().getAsDouble();
		System.out.println("평균 점수 : " + avg1);
		System.out.println("평균 점수 : " + avg2);
		
		
	}
}

class Student {
	String name;
	int score;
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
