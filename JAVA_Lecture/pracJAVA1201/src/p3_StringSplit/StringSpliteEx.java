package p3_StringSplit;

public class StringSpliteEx {
	public static void main(String[] args) {
		String text = "홍길동&이수홍,박연수,김자바-최명호";
		String[] names = text.split("&|,|-");
		for (int i = 0; i<names.length; i++) {
			System.out.println(names[i]);
		}
		System.out.println("------------------------");
		for (String name : names) {
			System.out.println(name);
		}
	}
}
