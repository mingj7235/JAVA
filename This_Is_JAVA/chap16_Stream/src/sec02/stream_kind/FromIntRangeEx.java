package sec02.stream_kind;

import java.util.stream.IntStream;

public class FromIntRangeEx {
	
	public static int sum;
	
	public static void main(String[] args) {
		
		IntStream stream = IntStream.rangeClosed(1, 100);
		stream.forEach(n -> sum += n);
		System.out.println("รัวี : " + sum);
	}
}
