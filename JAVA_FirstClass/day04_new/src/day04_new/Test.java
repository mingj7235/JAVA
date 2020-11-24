package day04_new;

public class Test {
	public static void main(String[] args) {
		
		//100~1까지 출력
		
		System.out.println("100 부터 1까지 출력 합니다.");
		for (int i = 0 ; i < 100; i++ ) {
			System.out.print((100 - i) + " ");
		}
		System.out.println("");
		
		//1~100까지 중 짝수만 출력하기
		
		System.out.println("1부터 100까지 중 짝수만 출력 합니다.");
		for (int i = 0; i < 51; i++) {
			System.out.print(i*2 + " ");
		}
		System.out.println("");
		
		//1~10까지의 합 구하기
		
		System.out.println("1부터 10까지 의 합을 출력 합니다.");
		int result = 0;
		int num = 10;
		for (int i = 0; i < num + 1 ; i++) {
			result += i;
		}System.out.println(result);
		//A~F까지 출력하기 (암호화로배운방법 - charAt사용)
		
		System.out.println("A~F까지 출력합니다. (암호화에서 charAt 배운것 활용)");
		String Eng1 = "ABCDEF";
		String result1 = "";
		for (int i = 0; i < 6; i++) {
			result1 += Eng1.charAt(i);
		}System.out.println(result1);
		
		//A~F까지 출력하기 (아스키코드 활용)
		
		System.out.println("A~F까지 출력합니다. (아스키코드 활용)");
		for (int i = 65; i < 71; i++) {
			System.out.print((char)i + " ");
		}
		System.out.println("");
		
		//A~F까지 중 C 제외하고 출력하기 (암호화로배운방법 - charAt사용)
		
		System.out.print("A~F까지 중 C제외하고 출력합니다. (암호화에서 charAt 배운것 활용)");
		String Eng2 = "ABCDEF";
		String result2 = "";
		for (int i = 0; i < 6; i++) {
			if (i == 2) {
				System.out.println("");
			}else {
				result2 += Eng2.charAt(i);
			}
		}System.out.println(result2);
		
		//A~F까지 중 C 제외하고 출력하기 (아스키코드 활용)
		System.out.println("A~F까지 중 C제외하고 출력합니다. (아스키코드 활용)");
		for (int i = 65; i < 71; i++) {
			if (i == 67) {
				System.out.print("");
			}else {
				System.out.print((char)i + " ");
			}
		}
		System.out.println("");
		//aBcDeFgH....Z 출력하기
	
		System.out.println("aBcDeFgH...Z 를 출력합니다.");
		for (int i = 66 ; i < 91; i = i +2) {
			System.out.print((char) (i + 31));
			System.out.print((char) i);
		}
		System.out.println("");
		
		//0 1 2 0 1 2 0 1 2 출력하기 (%모듈려스 사용하기)
		
		System.out.println("0 1 2 0 1 2 0 1 2 를 출력합니다 (%모듈려스 사용하기)");
		int result3= 0;
		for (int i = 0; i < 9; i++) {
			result3 = i % 3;
			System.out.print(result3 + " ");		
		}
	}



}
