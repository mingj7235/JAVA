package Q03;

import java.util.HashMap;

public class Q3_main {
	public static void main(String[] args) {
		HashMap<Q3_Student, String> hashMap = new HashMap<>();
		
		hashMap.put(new Q3_Student("1"), "95");
		
		String score = hashMap.get(new Q3_Student("1"));
		System.out.println("1번 학생의 총점 : " + score);
	}
}
