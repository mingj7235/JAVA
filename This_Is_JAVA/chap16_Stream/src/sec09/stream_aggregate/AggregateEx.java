package sec09.stream_aggregate;

import java.util.Arrays;
import java.util.OptionalInt;

public class AggregateEx {
	public static void main(String[] args) {
		long count = Arrays.stream(new int [] {1,2,3,4,5})
			.filter(n -> n %2 ==0)
			.count(); //count() 리턴 타입이 long이므로
		
		System.out.println("2의 배수 개수 : " + count);
		
		int sum = Arrays.stream(new int [] {1,2,3,4,5})
			.filter(n -> n%2 ==0)
			.sum();
		System.out.println("2의 배수의 합 : " +sum);
		
		int max =Arrays.stream(new int [] {1,2,3,4,5})
			.filter(n -> n%2 ==0)
			.max()
			.getAsInt();	//optionalInt타입으로 max()가 리턴되기 때문에
		System.out.println("최대값 : " + max);
		
		int min =Arrays.stream(new int [] {1,2,3,4,5})
				.filter(n -> n%2 ==0)
				.min()
				.getAsInt();	//optionalInt타입으로 min()가 리턴되기 때문에
		System.out.println("최소값 : " + min);
		
		int firstValue = Arrays.stream(new int [] {1,2,3,4,5})
			.filter(n -> n%3 ==0)
			.findFirst()
			.getAsInt();
		System.out.println("3의 배수중 첫번째 값 : " + firstValue);
	}
}
