package sec08.stream_match;

import java.util.Arrays;

public class MatchEx {
	public static void main(String[] args) {
		int [] intArr = { 2,4,6 };
		
		//allMatch
		boolean result = Arrays.stream(intArr).allMatch(a -> a%2 ==0);
		System.out.println("모두 2의 배수인가 ? " + result);
		
		//anyMatch
		result = Arrays.stream(intArr).anyMatch(a -> a%3 ==0);
		System.out.println("3의 배수가 있는가? " + result );
		
		//nonMatch
		result = Arrays.stream(intArr).noneMatch(a -> a%5 ==0);
		System.out.println("5의 배수가 전혀 없는가? " + result);
	}
}
