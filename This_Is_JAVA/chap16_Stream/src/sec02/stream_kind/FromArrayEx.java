package sec02.stream_kind;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FromArrayEx {
	public static void main(String[] args) {
		//배열에서 스트림얻어오는 법
		String [] strArray = {"홍길동", "신용권", "김미나"};
		Stream<String> strStream = Arrays.stream(strArray); //Arrays.stream(배열)
		strStream.forEach(a -> System.out.print(a + ", ")); //a는 요소를 대입함. 
		
		System.out.println();
		
		int [] intArray = {1,2,3,4,5};
		IntStream intStream = Arrays.stream(intArray);
		intStream.forEach(i -> System.out.print(i + ", "));
		
	}
}
