package sec01.stream_introduction;

import java.util.Arrays;
import java.util.List;

public class MapAndReduceEx {
	public static void main(String[] args) {
		
		List<Student> studentList = Arrays.asList(
				new Student("홍길동", 10),
				new Student("신용권", 20),
				new Student("유미선", 30)
		);
		
		//중간처리 : 매핑!! mapTo타입 () 으로 해서 그 해당 타입으로 새로 stream의 요소로 바꾸는 것 
		//최종처리 : 평균!! average() !!!
//		studentList.stream().mapToInt(s->s.getScore()) 이방식도있고
		double avg = studentList.stream()	 //오리지날 스트림
				.mapToInt(Student :: getScore) //중간 처리하여, 매핑하는것. 스튜던트에서 스코어를 얻어내는것
				.average()	//최종처리. 중간에서 얻은 점수 스트림을 활용하여 평균값을 구하는 매소드. 근데 이게 리턴하는 것이 OptionalDouble이라서
				.getAsDouble();	// getAsDouble() 메소드를 활용하여 average() 값을 리턴하도록함.
		
		System.out.println("평균 점수 : "  + avg);
		
	}
}
