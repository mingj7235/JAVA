package review;

public class Access {
	
	int data1 = 10;
	public int data2 = 20;
	protected int data3 = 30;
	private int data4 = 40;
	
	
	
	public int getData4() {
		return data4;
	}



	public void setData4(int data4) {
		this.data4 = data4;
	}



	void f () {
	}
	
	
}

class Cloud {
	
	void function () {
		Access a =  new Access ();
	}
	
	
	
	
	
	
	
}
