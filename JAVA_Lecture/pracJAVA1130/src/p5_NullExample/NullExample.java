package p5_NullExample;

import java.util.Objects;

public class NullExample {
	public static void main(String[] args) {
		String str1 = "홍길동";
		String str2 = null;
		//null값 잡을때 좋겠네. null인지 아닌지 구분하는 것임
		System.out.println(Objects.isNull(str1)); //null입니까?
		System.out.println(Objects.isNull(str2));
		System.out.println(Objects.nonNull(str1));//null이아닙니까?
		System.out.println(Objects.nonNull(str2));
		System.out.println(Objects.requireNonNull(str1)); //null일경우에는 Nullpointexception발생함
//		try {
//			System.out.println(Objects.requireNonNull(str2, "null임"));
//		} catch (NullPointerException e) {
//			System.out.println(e.getMessage());
//		}
		System.out.println("====================");
		System.out.println(Objects.toString(str1));
		System.out.println(Objects.toString(str2));
		System.out.println(Objects.toString(str2, "기본값"));//null이 나오면 기본값을 출력해줌. 
		
	}
}
