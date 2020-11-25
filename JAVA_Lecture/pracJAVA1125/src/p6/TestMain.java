package p6;

public class TestMain {
	public static void main(String[] args) {
		Outer ot = new Outer();
		Outer.Inner in= ot.new Inner();
		
		in.i1Method();
		
	}
}
