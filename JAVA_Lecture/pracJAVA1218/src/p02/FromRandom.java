package p02;

import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class FromRandom {
	public static void main(String[] args) {
		Random r = new Random();
		IntStream is = r.ints();
		is.forEach(a ->System.out.println(a));
		
		LongStream ls = r.longs();
		ls.forEach(a->System.out.println(a));
		
		DoubleStream ds = r.doubles();
		ds.forEach(a->System.out.println(a));
		
	}
}
