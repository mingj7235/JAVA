package sec05.stream_mapping;

import java.util.Arrays;
import java.util.stream.IntStream;

public class AsDoubleStreamAndboxedEx {
	public static void main(String[] args) {
		
		int [] intArray = {1,2,3,4,5};
		IntStream intStream = Arrays.stream(intArray);
		intStream.asDoubleStream().forEach(d -> System.out.println(d));
		
		System.out.println();
		
		intStream = Arrays.stream(intArray);
		intStream.boxed().forEach(i -> System.out.println(i)); //boxed는 박싱한다. 즉 각각의 int값을 Integer로 박싱한것임.
		
	}
}
