package day16Review;

public class Car {
	//final은 상수. 밑에서 수정할 수 없게끔 만들어주는 것.
	final int wheel = 4;	
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
	
	void engineStop ()	{
		System.out.println("열쇠로 시동 끔");
		
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
}
