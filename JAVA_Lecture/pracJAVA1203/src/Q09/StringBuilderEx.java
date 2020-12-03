package Q09;

public class StringBuilderEx {
	public static void main(String[] args) {
		String str = "";
		for (int i = 0; i < 100; i++) {
			str += i;
		}
		System.out.println(str);
		
		//개선코드
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 100; i++) {
			sb.append(i);
		}
		str = sb.toString();
		System.out.println(str);
	}
}
