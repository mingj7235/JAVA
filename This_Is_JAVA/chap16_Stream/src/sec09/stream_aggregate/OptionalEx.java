package sec09.stream_aggregate;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalEx {
	public static void main(String[] args) {
		List <Integer> list = new ArrayList <> ();
		
		
		//List에 요소가 없음. 
		/*double avg = list.stream()
//				.mapToInt(Integer :: intValue) //intValue는 인트값의 벨류들을 불러온느것임.
				.mapToInt(n -> n.intValue())
				.average() // 결과 값이 집계 되지 않음 -> 예외가 발생 (NoSuchElementException)
				.getAsDouble();
		
		System.out.println(avg);*/
		
		//요소가 있는지 없는지 확인후 출력 방법1 : isPresent
		OptionalDouble optional = list.stream()
			.mapToInt(Integer::intValue)
			.average();
		if (optional.isPresent()) { //true가 나오면 값이 있는것이고, false면 값이 없는것
			System.out.println("방법 1 평균 : " + optional.getAsDouble());
		}else {
			System.out.println("방법 1 평균 : 0.0");
		}
		
		// 방법 2 : orElse
		double avg = list.stream()
				.mapToInt(Integer::intValue)
				.average()
				.orElse(0.0); //결과값이 없을경우에 여기 매개값에 넣을 것을 씀!
		System.out.println("방법 2 평균 : " + avg);
		
		//방법 3 : ifPresent
		
		list.add(3);
		list.add(6);
		
		list.stream()
			.mapToInt(Integer::intValue)
			.average()
			.ifPresent(a -> System.out.println("방법 3 평균 : " + a)); //값이 average()에 있다면 a를 출력
								//값이 없다면 false가 되어서 아무일도 생기지않음
		
	}
}
