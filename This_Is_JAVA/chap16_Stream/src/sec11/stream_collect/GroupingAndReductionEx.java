package sec11.stream_collect;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingAndReductionEx {
	public static void main(String[] args) {
		List <Student> totalList = Arrays.asList(
				new Student ("홍길동", 10, Student.Sex.MALE),
				new Student ("김수애", 12, Student.Sex.FEMALE),
				new Student ("신용권", 10, Student.Sex.MALE),
				new Student ("박수미", 12, Student.Sex.FEMALE)
		);
		
		Map<Student.Sex, Double> mapBySex = totalList.stream()
				.collect(
						Collectors.groupingBy(
								Student :: getSex,
								Collectors.averagingDouble(Student :: getScore)
								)
						);
		
		System.out.println("남학생 평균 점수" + mapBySex.get(Student.Sex.MALE));
		System.out.println("여학생 평균 점수" + mapBySex.get(Student.Sex.FEMALE));
		
		
		Map <Student.Sex, String> mapByName = totalList.stream()
				.collect(
						Collectors.groupingBy(
								Student :: getSex,	//키! 
								Collectors.mapping( //값! 학생의 요소에서 이름을 매핑을 통해 얻어야하므로 매핑 
										Student :: getName,
										Collectors.joining(", ") //, 이걸로 연결하는것임
										)
								)
						);
		System.out.println("남학생 전체 이름 : " + mapByName.get(Student.Sex.MALE));
		System.out.println("여학생 전체 이름 : " + mapByName.get(Student.Sex.FEMALE));
		
	}
}
