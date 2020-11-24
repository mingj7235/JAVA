package car;

public class SuperCar extends Car{
	String mode;
	
	public SuperCar() {;}

	public SuperCar(String brand, String color, int price, String mode) {
		super(brand, color, price);
		this.mode = mode;
	}
	
	@Override
	void engineStart() {
		System.out.println("음성으로 시동 킴");
		super.engineStart();
	}
	
	@Override
	void engineStop() {
		System.out.println("음성으로 시동 끔");
		super.engineStop();
	}
	
}
