package shopservice;

public class ShopService {
	public static void main(String[] args) {
		ShopServiceExample obj1 = ShopServiceExample.getInstance();
		ShopServiceExample obj2 = ShopServiceExample.getInstance();
		
		if (obj1 == obj2) {
			System.out.println("°°Àº °´Ã¼");
		}else {
			System.out.println("´Ù¸¥ °´Ã¼");
		}
	}
}
