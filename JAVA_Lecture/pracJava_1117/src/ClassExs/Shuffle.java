package ClassExs;

import java.util.Random;

public class Shuffle {
	public static int [] shuffle (int [] arr) {
		Random r = new Random();
		if (arr == null || arr.length == 0) {
			return arr;
		}
		for (int i = 0; i < arr.length; i++) {
			int j = r.nextInt(arr.length);
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int [] original = {1,2,3,4,5,6,7};
		System.out.println(java.util.Arrays.toString(original));
		int [] changed = shuffle(original);
		System.out.println(java.util.Arrays.toString(changed));
	}
}
