package day04_new;


public class MethodTest {
	void chagKor (String data)	{
		String kor = "¿µÀÏÀÌ»ï»ç¿ÀÀ°Ä¥ÆÈ±¸";
		String result = "";
		int num = Integer.parseInt(data);
		
		for (int i = 0; i < data.length(); i++) {
			result += kor.charAt((num % 10));
			num /= 10;
		}
		
		for (int i = data.length() -1 ; i > -1; i--) {
			System.out.print(result.charAt(i));
		}
	
	}

		public static void main(String[] args) {
		MethodTest m = new MethodTest();
		
		m.chagKor("3456");
			
	}
				
		
		
		
}
