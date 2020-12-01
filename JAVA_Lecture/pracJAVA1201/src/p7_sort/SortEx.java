package p7_sort;

import java.util.Arrays;

public class SortEx {
	public static void main(String[] args) {
		int [] scores = {99,98,87,100};
		double [] avg = {4.5, 1.2, 100, -10.0};
		String [] stringArr = {"김수진", "김미", "박수진", "황수연"};
		for (int  s : scores) {
			System.out.print(s + "  ");
		}
		System.out.println();
		System.out.println("sort 후 ___");
		Arrays.sort(scores);
		for (int s : scores) {
			System.out.print(s + "   ");
		}
		
		Arrays.sort(avg);
		Arrays.sort(avg);
		System.out.println();
		for (double s : avg) {
			System.out.print(s + "   ");
		}
		System.out.println();
		Arrays.sort(stringArr);
		for (String s : stringArr) {
			System.out.print(s + "  ");
		}
		
	}
}
class Member {
	int sno;//번호
	String sname;//회원이름
	String stel;//전화번호
}
