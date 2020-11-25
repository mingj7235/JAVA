package p4;

public class B {
	final int x = 10;
	int y = 20;
	
	void bMethod1 () {
		y = x + 20;
	}
	final void bMethod2 () {
		y = x + 200;
	}
	
}