package generic;
//Generic Method
public class GTest2 {
	
//	public static <T1, T2> T2 function (T1 data) {	//제네릭을 이렇게 2번써도된다. T1, T2
//		T2 result;
//		if (data instanceof Integer) {
//			result = (T2) "정수";
//		} else if (data instanceof Double || data instanceof Float) {
//			result = (T2) "실수";
//		} else if (data instanceof Character) {
//			result = (T2) "문자";
//		} else if (data instanceof String) {
//			result = (T2) "문자열";
//		} else {
//			result = null;
//		}
//		return result;
//	}
	
	public static <T> T function (T data) {
		T result;
		if (data instanceof Integer) {
			result = (T) "정수";
		} else if (data instanceof Double || data instanceof Float) {
			result = (T) "실수";
		} else if (data instanceof Character) {
			result = (T) "문자";
		} else if (data instanceof String) {
			result = (T) "문자열";
		} else {
			result = null;
		}
		return result;
	}
	

	//질문 : (T) "정수" ...? 이게 어떻게 되는걸까
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
