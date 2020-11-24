package day10;
//2중 포문 => 2차원 배열을 위해서 꼭 숙지해야함. 
public class NastedFor {
	public static void main(String[] args) {
		for(int i = 1 ; i <10 ; i++) {
			for (int j = 1 ; j < 10 ; j++) {
				System.out.printf("%d*%d=%d\n", i,j,i*j);
			}
			System.out.println();
		}
	}
}
