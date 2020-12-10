package sec07.stream_looping;

import java.util.Arrays;

public class LoopingEx {
	public static void main(String[] args) {
		int [] intArr = {1,2,3,4,5};
		
		System.out.println("[peek()]를 마지막에 호출한 경우");
		Arrays.stream(intArr)
			.filter(a -> a%2 == 0)
			.peek(a -> System.out.println(a));
		//중간 처리 메소드이므로, 최종처리 메소드가 없으면 동작하지 않음. ! 
		System.out.println();
		
		Arrays.stream(intArr)
		.filter(a -> a%2 == 0)
		.peek(a -> System.out.println(a))
		.forEach(a -> System.out.println(a)); //forEach 최종이 나오므로 peek도 작동해서 2번씩 찍힘
		System.out.println();
		
		int total  = Arrays.stream(intArr)
		.filter(a -> a%2 == 0)
		.peek(a -> System.out.println(a))
		.sum();
		
		System.out.println("총합 : " + total);
		//peek 도 동작하고, sum을 담은 total을 출력함. 
		
	}
}
