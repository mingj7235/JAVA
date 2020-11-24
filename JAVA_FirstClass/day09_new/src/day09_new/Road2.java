package day09_new;

class Car2 {
	String brand;
	String color;
	int price;
	boolean isOn;

	public Car2() {;}

	public Car2(String brand, String color, int price) { 
		this.brand = brand;
		this.color = color;
		this.price = price;
	}
	
	//메서드의 리턴은 여러가지가 선언될수 있으나
	//첫 리턴을 만나면 그 메서드는 끝이난다. 
	boolean engineStart () {
		if(!isOn) {
			return true;
		}
		return false;
	}
	boolean engintStop() {
		if(isOn) {
			return true;
		}
		return false;
	}
	
}

public class Road2 {
	public static void main(String[] args) {
		Car2 myCar = new Car2();
		if (myCar.engineStart()) {
			myCar.isOn = true;
			System.out.println("시동 켬");
		}else {
			System.out.println("이미 시동이 켜져 있습니다. ");
		}
		
		if (myCar.engineStart()) {
			myCar.isOn = false;
			System.out.println("시동 끔");
		}else {
			System.out.println("이미 시동이 꺼져 있습니다. ");
		}
		
	}



}
