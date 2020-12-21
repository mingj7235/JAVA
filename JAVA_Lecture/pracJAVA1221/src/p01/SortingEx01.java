package p01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class SortingEx01 {
	public static void main(String[] args) {

		// 숫자 요소일 경우
		IntStream intStream = Arrays.stream(new int[] {5, 3, 2, 1, 4});
		intStream
		.sorted()
		.forEach(n -> System.out.print(n+" "));
		System.out.println();
		
		// 객체 요소일 경우
		List<Student> studentList = Arrays.asList(new Student("홍길동", 10),
													new Student("정현희", 30),
													new Student("박명자", 25)
													);
		
		studentList.stream()
		.sorted()
		.forEach(s -> System.out.print(s.getName()+"-"+s.getScore()+" "));
		System.out.println();
		
		// 내림차순 정렬하기
		studentList.stream()
		.sorted(Comparator.reverseOrder())
		.forEach(s -> System.out.print(s.getName()+"-"+s.getScore()+" "));
		
	}

}
class Student implements Comparable<Student> {
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
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	}