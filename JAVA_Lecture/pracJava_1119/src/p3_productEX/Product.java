package p3_productEX;

public class Product {
	int price;
	int bonusPoint;
	
	public Product(int price) {
		this.price = price;
		bonusPoint = price/10;
	}
	
	public Product() {
	}
}
