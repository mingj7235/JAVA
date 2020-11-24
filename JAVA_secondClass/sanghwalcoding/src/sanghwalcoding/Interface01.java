package sanghwalcoding;

public interface Interface01 {
	void data1 (int age, String name);
	String data2	();
}
	
interface Interface02 extends Interface01{
	String data3 ();
}


class A implements Interface02 {

	@Override
	public String data3() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void data1(int age, String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String data2() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
