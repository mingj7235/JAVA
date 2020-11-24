package day09_new;

class Car {
	final int wheel = 4;
	int price;
	String color;
	String brand;
	boolean isOn;
	
	public Car() {;}

	public Car(int price, String color, String brand) {
		this.price = price;
		this.color = color;
		this.brand = brand;
	}
	
	boolean engineStart () {
		if(!isOn) {
			return true;
		}
		return false;
	}
	
	boolean engineStop () {
		if(isOn) {
			return false;
		}
		return true;
	}
	
	public String toString() {
		return "가격 : " + this.price + "\n색상 : " + this.color + "\n브랜드 : " + this.brand;  
	}
}


public class CarTask {
	public static void main(String[] args) {
		Car myCar = new Car(5000, "Black", "Benz");
		System.out.println(myCar);
		
		if(myCar.engineStart()) {
			myCar.isOn = true;
			System.out.println("시동이 켜졌습니다.");
		}else {
			System.out.println("시동이 이미 켜져있습니다. ");
		}
		
		
		
	}
	
	
	
	
	
}
