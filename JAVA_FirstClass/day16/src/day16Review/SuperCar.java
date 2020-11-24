package day16Review;

public class SuperCar extends Car{
	String mode;
	public SuperCar() {
		System.out.println("자식클래스의 기본 생성자");
	}
	
	public SuperCar(String brand, String color, int price, String mode) {
		super (brand, color, price);
//		setPrice(price);
		//price는 private 변수이므로 super를 사용하여 초기화해도되고, setter를 사용해서 초기화 해도된다. 
		this.mode = mode;
		//부모클래스에 없는  mode는 따로 this를 써서 초기화 시킨다. 
	}
	

	@Override
	void engineStart() {
		System.out.println("음성으로 시동 킴");
	}
	
	@Override
	void engineStop() {
		System.out.println("음성으로 시동 끔");
	}
	
	
	@Override
	public String toString() {
		return "브랜드 : " + this.brand + "\n색상 : " + this.color + "\n가격 : " + getPrice() + "만원";
	}
	
}
