package Q07;

public class FindandReplaceEx {
	public static void main(String[] args) {
		String str = "모든 프로그램은 자바 언어로 개발 될 수 있다.";
		int index = str.indexOf("자바");
//		System.out.println(index);
		if (index == -1) {
			System.out.println("자바 문자열이 포함되어 있지 않슴다");
		} else {
			System.out.println("자바 문자열이 포함되어 있슴");
			str = str.replace("자바", "JAVA");
			System.out.println("-->" + str);
		}
	}
}
