package p6_Array;

import java.util.Arrays;

public class ArraysEx02 {
	public static void main(String[] args) {
		int [][] original = {{1,2}, {3,4}};
		System.out.println("얕은 복제");
		int [][] cloned1 = Arrays.copyOf(original, original.length);
		System.out.println("배열 번지 비교 : " + original.equals(cloned1)); //equal은 본래 주소 비교 //false
		System.out.println("1차원 배열 항목 값 비교 : " + Arrays.equals(original, cloned1));//true
		//0행의 주소복사, 1행의 주소 복사
		System.out.println("중첩 배열 항목 값 비교 : " + Arrays.deepEquals(original, cloned1));//true
		//////
		System.out.println("깊은 복제");
		int [][] cloned2 = Arrays.copyOf(original, original.length);
		cloned2 [0] = Arrays.copyOf(original[0], original.length);
		cloned2 [1] = Arrays.copyOf(original[1], original.length);
		System.out.println("배열 번지 비교 : " + original.equals(cloned2)); //equal은 본래 주소 비교 //false
		System.out.println("1차원 배열 항목 값 비교 : " + Arrays.equals(original, cloned2));//true
		//0행의 주소복사, 1행의 주소 복사
		System.out.println("중첩 배열 항목 값 비교 : " + Arrays.deepEquals(original, cloned2));//true
	}
}
