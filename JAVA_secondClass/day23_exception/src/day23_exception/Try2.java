package day23_exception;

public class Try2 {
	public static void main(String[] args) {
		int [] arData = new int [5];
		
		for (int i = 0; i < 100; i++) {
			try {
				arData[i] = i +1;
			} catch (Exception e) {
				break;
			}
		}
		for (int i = 0; i < arData.length; i++) {
			System.out.println(arData[i]);
		}
		
		System.out.println("정상종료");
		
	}
}
