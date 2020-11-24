package p8;

public class RunClassEx implements Inter0101, Inter0102 {

	@Override
	public void inter01Method() {
		int r ;
		r = x + y;
		System.out.println(r);
	}
	@Override
	public void inter0101Method() {
		double r;
		r = x + y + z;
		System.out.println(r);
	}

	@Override
	public void inter0102Method() {
//		x = y;  // x는 상수이기 때문에 변경 안됌
		double r ;
		r = x + z;
		System.out.println(r);
	}
}
