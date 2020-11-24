package day16;

public class Car {
	final int wheel = 4;
	//final은 수정이 절대 불가능하다. (상수)
	public String brand;
	protected String color;
	private int price;
	
	public Car() {
		System.out.println("부모 클래스의 기본 생성자");
	}

	public Car(String brand, String color, int price) {
		this.brand = brand;
		this.color = color;
		this.price = price;
	}
	
	void engineStart () {
		System.out.println("열쇠로 시동 킴");
	}
	
	void engineStop () {
		System.out.println("열쇠로 시동 끔");
		
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
