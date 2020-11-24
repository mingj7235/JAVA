package day06_new;

public class prac {
	public static void main(String[] args) {
			int [] arData = {3, 5, 2, 9};
			System.out.println(arData.length);

			System.out.println("length 사용 안했을 때 ");
			for (int i = 0; i < 4; i++) {
				System.out.print(arData[i] + " ");
			}
			System.out.println();
			
			System.out.println("length 사용 안했을 때 ");
			for (int i = 0; i < arData.length; i++) {
				System.out.print(arData[i] + " ");
			}
			
			
			
	}
}
