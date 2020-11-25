package p2;

public class MethodClass {
	int n;
	int m;
	public int sum (int n) {
//		this.n = n;
		int result= 0;
		for (int i = 0; i < n; i++) {
			result += (i+1);
		}
		return result;
	}
	public int minus (int n) {
		int result;
//		this.n = n;
		result = sum(n) -n;
		return result;
	}
	
	public long mult (int m) {
//		this.m = m;
		long result=1;
		for (int i = 0; i < m; i++) {
			result *= (i+1);
		}
		return result;
	}
}
