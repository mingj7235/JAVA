package Q08;

import java.util.StringTokenizer;

public class SplitEx {
	public static void main(String[] args) {
		String str = "아이디,이름 ,패스워드";

		// 방법 1 (split() 메소드 이용)
		
		String [] names = str.split(",");
		for (String name : names) {
			System.out.println(name);
		}
		
		//방법 2 (StringTokenizer이용)
		
		StringTokenizer st = new StringTokenizer(str, ",");
		int cnt = st.countTokens();
		for (int i = 0; i < cnt; i++) {
			String tke = st.nextToken();
			System.out.println(tke);
		}
		
	}
}
