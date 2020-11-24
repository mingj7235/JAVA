package day07_new;

import java.util.Scanner;

public class ArTask_mine {
	public static void main(String[] args) {
		//1~n 까지 배열에 담고 총 합 구하기
		Scanner sc = new Scanner(System.in);
		String msg = "1~n 까지 의 합을 구할겁니다. \n"
				+ "n의 값을 입력해주세요 : ";
		int result = 0;
		
		System.out.println(msg);
		int [] arData = new int [sc.nextInt()];
		for (int i = 0; i < arData.length; i++) {
			result += i+1;
		}
		System.out.println(result);
		
	}
}
