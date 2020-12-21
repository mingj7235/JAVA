package p02;

import java.util.Arrays;

public class MatchingEx {
	public static void main(String[] args) {
		int [] intArr = {2,4,5};
		int [] testArr = {1,2,3,4,5};
		
		boolean result1 = Arrays.stream(intArr).allMatch(n -> n %2 ==0);
		System.out.println(result1);
		
		boolean result2 = Arrays.stream(intArr).anyMatch(n -> n %3 ==0);
		System.out.println(result2);
		
		boolean result3 = Arrays.stream(intArr).noneMatch(n -> n %3 ==0);
		System.out.println(result3);
		
		int num =Arrays.stream(testArr).filter(n ->n%2==0).findFirst().getAsInt();
		System.out.println(num);
		
		
		
		
		
		
	}
}
