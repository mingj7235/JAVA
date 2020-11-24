package p4;

public class GoodCalc extends Calculator{

	@Override
	public int add(int a, int b) {
		return a+b;
	}

	@Override
	public int subtract(int a, int b) {
		return a-b;
	}

	@Override
	public double average(int[] a) {
		int sum = 0;
		double result = 0.0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		result = (double) sum /a.length;
		return result;
	}

}
