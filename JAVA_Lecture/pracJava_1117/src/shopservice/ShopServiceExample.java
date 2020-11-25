package shopservice;

import java.util.Calendar;

public class ShopServiceExample {
	private static ShopServiceExample singleton = new ShopServiceExample();
	
	private ShopServiceExample() {

	}
	
	static ShopServiceExample getInstance () {
		return singleton;
	}
	
}
