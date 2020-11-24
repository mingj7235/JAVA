package car;

public class Car {
	final int wheel =4;
	String brand;
	String color;
	int price;
	
	public Car() {;}
	
	public Car(String brand, String color, int price) {
		super();
		this.brand = brand;
		this.color = color;
		this.price = price;
	}

	void engineStart () {
		System.out.println("¿­¼è·Î ½Ãµ¿ Å´");
	}
	
	void engineStop () {
		System.out.println("¿­¼è·Î ½Ãµ¿ ²û");
	}
	
	
}
