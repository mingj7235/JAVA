package p02;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import p01.Student;

public class GrupingByAndReductionEx {
	public static void main(String[] args) {
		List<Student> totalList=Arrays.asList(
	            new Student("홍길동", 10, Student.Sex.MALE,Student.City.PUSAN),
	            new Student("김수애", 6, Student.Sex.FEMALE,Student.City.SEOUL),
	            new Student("신용권", 10, Student.Sex.MALE,Student.City.PUSAN),
	            new Student("박수미", 6, Student.Sex.FEMALE,Student.City.SEOUL),
	            new Student("박수호", 6, Student.Sex.MALE,Student.City.SEOUL)
	            );
		//성별로 평균 점수 구하는 Map 얻기
		
		Map<Student.Sex, Double> mapBySex = totalList.stream()
				.collect(Collectors.groupingBy(Student :: getSex,
						Collectors.averagingDouble(Student::getScore)));
		
		System.out.println("남학생 평균 점수 : " +mapBySex.get(Student.Sex.MALE));
		System.out.println("여학생 평균 점수 : " +mapBySex.get(Student.Sex.FEMALE));
	
		Map<Student.Sex, Long> countBySex = totalList.stream()
				.collect(Collectors.groupingBy(Student :: getSex,
						Collectors.counting()));
		
		System.out.println("남학생 수  :" + countBySex.get(Student.Sex.MALE));
		System.out.println("여학생 수  :" + countBySex.get(Student.Sex.FEMALE));
		
		//성별을 쉼표로 구분하는 이름을 저장하는 Map 얻기 (ex>
		
		Map<Student.Sex, String> nameBySex = totalList.stream()
				.collect(Collectors.groupingBy(Student::getSex,
										Collectors.mapping(Student :: getName, 
																		Collectors.joining(",")))); //joining은 String 타입을 매개값으로 구분하게해준다
		
		System.out.println("남학생 : " + nameBySex.get(Student.Sex.MALE));
		
		
	}
}
