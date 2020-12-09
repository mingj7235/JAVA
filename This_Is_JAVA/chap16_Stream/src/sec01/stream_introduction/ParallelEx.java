package sec01.stream_introduction;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelEx {
	public static void main(String[] args) {
		List <String>list = Arrays.asList("홍길동", "신용권", "감자바", "람다식", "박병렬");
		
		//순자처리 (싱글스레드)
		Stream<String> stream = list.stream();
//		stream.forEach(name -> print(name));
		stream.forEach(ParallelEx :: print); //람다식 메소드 참조 매개값도 생략이된다. 개쩜;
		
		System.out.println(); //개행
		
		//병렬처리 (멀티스레드)
		Stream<String> parallelStream = list.parallelStream();
//		stream.forEach(name -> print(name));
		parallelStream.forEach(ParallelEx :: print);
		
	
	}
	public static void print (String str) {
		System.out.println(str + " : " + Thread.currentThread().getName());
	}
	
	/* 결과값
	 * 홍길동 : main
		신용권 : main
		감자바 : main
		람다식 : main
		박병렬 : main
		
		감자바 : main
		신용권 : ForkJoinPool.commonPool-worker-1
		박병렬 : ForkJoinPool.commonPool-worker-2
		람다식 : ForkJoinPool.commonPool-worker-2
		홍길동 : ForkJoinPool.commonPool-worker-2
	 */
}
