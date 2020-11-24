package day24_API;

//친절한 개발자가 되어야 한다.

/**
 * This is a high quality Calculator
 * @author JOSHUA 
 *	@since 2020 10 10
 */

public class Calc {
	/**
	 * To add the following numbers.<br>
	 * For example <br>
	 * 		add(1, 3) return 4 <br>
	 * 
	 * @param num1 : First Integer for add
	 * @param num2 : Last Integer for add
	 */
	public static void add (int num1, int num2) {
		System.out.println(num1 + num2);
	}
	
	/**
	 * To divide the following numbers. <br>
	 * For example <br>
	 * 		div(3, 6) return 0.50 <br>
	 * If you give 0 to num2, you should see "You cannon divide number using 0"<br>
	 * 
	 * @param num1
	 * @param num2
	 * @return void
	 */
	
	public static void div (int num1, int num2) {
		try {
			System.out.println(num1/num2);
		} catch (Exception e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}
		
	}
//		String result = "";
//		try {
//			result = String.format("%.2f", (double) num1 / num2);
//			if (num2 != 0) {
//				return result;
//			} else {
//				return "0으로 나눌 수 없습니다.";
//			}
//		} catch (Exception e) {
//			return 	"정수를 올바르게 넣어주세요.";
//		}
//	}
	
	
	public static void main(String[] args) {
		Calc.add(1, 3);
		Calc.div(3, 8);
	}
	
	
}
