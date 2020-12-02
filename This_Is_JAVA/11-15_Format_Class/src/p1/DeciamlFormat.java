package p1;

import java.text.DecimalFormat;

public class DeciamlFormat {
	public static void main(String[] args) {
		double num = 1234567.89;
		
		
		DecimalFormat df = new DecimalFormat("0");
		System.out.println(df.format(num)); //정수만 출력

		df = new DecimalFormat("0.0"); //실수 포함해서 출력 (
		System.out.println(df.format(num));
		
		df = new DecimalFormat("000000000000.000");
		System.out.println(df.format(num));
		
		df = new DecimalFormat("#");
		System.out.println(df.format(num));
		
		df = new DecimalFormat("#.#");
		System.out.println(df.format(num));
		
		df = new DecimalFormat("#############.###");
		System.out.println(df.format(num));
		
		df = new DecimalFormat("0.#");
		System.out.println(df.format(num));
		
		df = new DecimalFormat("+#.0"); //양수,음수
		System.out.println(df.format(num));
		
		df = new DecimalFormat("#,###.#");
		System.out.println(df.format(num));
		
		
	}
}
