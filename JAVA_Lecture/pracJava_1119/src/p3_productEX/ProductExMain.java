package p3_productEX;

public class ProductExMain {
	public static void main(String[] args) {
		Buyer mj = new Buyer();
		
		mj.buy(new TV());
		mj.buy(new Computer());
		mj.buy(new Audio());
		mj.buy(new IPhone());
		mj.buy(new NoteBook());
		
		mj.summary();
		
	}
}
