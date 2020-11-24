package generic;

public class Gnr {
	public static void main(String[] args) {
		GTest<String> g = new GTest<>();
		g.setData("гоюл");
		System.out.println(g.getData());
		
		GTest<Integer> i1 =new GTest<>();
		GTest<Integer> i2 =new GTest<>();
		i1.setData(123);
		i2.setData(new Integer(23));
		System.out.println(i1.getData());
		System.out.println(i2.getData());
		
	}
}
