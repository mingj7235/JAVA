package sec03.stream_pipelines;

import java.util.Arrays;
import java.util.List;

public class StreamPipelinesEx {
	public static void main(String[] args) {
		List <Member> list = Arrays.asList(  
			new Member("홍길동", Member.MALE, 30),
			new Member("김나리", Member.FEMALE, 20),	
			new Member("신용권", Member.MALE, 45),	
			new Member("박수미", Member.FEMALE, 27)	
		);
		
		double maleAgeAvg= list.stream()							//메인 스트림
				.filter(m -> m.getSex() == Member.MALE)		//filter 중간 스트림
				.mapToInt(Member :: getAge)							//mapping 중간 스트림
				.average()															//average() 최종 스트림
				.getAsDouble();													//Optionaldouble 타입을 double로 변환
		
		
		double femaleAgeAve = list.stream()
				.filter(m -> m.getSex()==Member.FEMALE)
				.mapToInt(Member :: getAge)
				.average().getAsDouble();
		
		
		System.out.println("남자 평균 나이 :"  + maleAgeAvg);
		System.out.println("여자 평균 나이 :"  + femaleAgeAve);
	}
}
