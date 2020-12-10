package sec11.stream_collect;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingEx {
	public static void main(String[] args) {
		List <Student> totalList = Arrays.asList(
				new Student ("홍길동", 10, Student.Sex.MALE, Student.City.Seoul),
				new Student ("김수애", 6, Student.Sex.FEMALE, Student.City.Pusan),
				new Student ("신용권", 10, Student.Sex.MALE, Student.City.Pusan),
				new Student ("박수미", 6, Student.Sex.FEMALE, Student.City.Seoul)
		);
		
		Map<Student.Sex, List <Student>> mapBySex =
				totalList.stream()
				.collect(Collectors.groupingBy(Student :: getSex)); //key로 무엇이 될것인가를 지정함 여기서는 성별이 key
		
		//성별로 그룹핑 잘되었는지 확인
		System.out.print("남학생 : "); //
		mapBySex.get(Student.Sex.MALE).stream()
			.forEach(m -> System.out.print(m.getName() + " "));
		
		System.out.print("여학생 :");
		mapBySex.get(Student.Sex.FEMALE).stream()
			.forEach(m -> System.out.print(m.getName()+ " "));
		
		Map<Student.City, List <String>> mapByCity = totalList.stream()
				.collect(
						Collectors.groupingBy(
								Student::getCity,//key로 무엇을 사용할 것인가 / city의 값을 키로 사용할것임
								Collectors.mapping(Student::getName, Collectors.toList())
							)
					);
		System.out.println("\n[서울]");
			mapByCity.get(Student.City.Seoul).stream()
			.forEach(name -> System.out.print(name + " "));
			
		System.out.println("\n[부산]");
		mapByCity.get(Student.City.Pusan).stream()
		.forEach(name -> System.out.print(name + " "));
	}
}
