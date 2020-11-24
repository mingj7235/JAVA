package day16;

public class SuperCar extends Car{
	String mode;
	
	public SuperCar() {
		System.out.println("자식 클래스의 기본 생성자");
		
	}
	
	public SuperCar(String brand, String color, int price, String mode) {
		//부모생성자에서 이미 this로 초기화를 시켜놨으므로
		//super()를 불러와서 초기화시킨 변수들을 불러오기만 하면된다.
		//super()는 부모클래스의 생성자다.
		//자식클래스 생성자에서 받은 값들이 super()를통해 부모 생성자로 값을 넘기는것이다.
		//그래서 부모생성자로 다시 넘어가서 초기화되는것임.
		super(brand, color, price);
		//price는 private 변수이기때문에 setPrice로 접근가능하다.
//		setPrice(price);
		this.mode = mode;
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
		return "브랜드 : " + this.brand + "\n색상 : " + color + "\n가격 : " + getPrice() + "만원";
	}
	

	public static void main(String[] args) {
		SuperCar myCar = new SuperCar();
		
		
		
	}
	
	
}
