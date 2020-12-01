package p4_token;

import java.util.StringTokenizer;

public class StringTokenEx {
	public static void main(String[] args) {
		String text = "홍길동/이수홍/박연수";
		
		StringTokenizer st1 = new StringTokenizer(text, ";"); //구분자가 없으면 토큰을 그냥 문자열 전체 한덩어리로 봄
		StringTokenizer st2 = new StringTokenizer(text, "/"); //
		int count1 = st1.countTokens();
		System.out.println("토큰의 갯수 " + count1);
		int count2 = st2.countTokens();
		System.out.println("토큰의 갯수 " + count2);
		
//		for (int i = 0; i < count2; i++) {
//			String tokenValue = st2.nextToken();
//			boolean hmt = st2.hasMoreTokens();
//			System.out.println("남아있는 토큰이 있으면 true, 없으면 false : "+hmt);
//			System.out.println(tokenValue);
//		}
		while (st2.hasMoreTokens()) {
			String tokenValue = st2.nextToken();
			System.out.println(tokenValue);
		}
		
		//StringTokenizer는 구분자가 
	}
}
