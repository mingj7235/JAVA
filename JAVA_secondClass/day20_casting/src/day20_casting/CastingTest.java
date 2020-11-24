package day20_casting;

class Car {
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
		System.out.println("열쇠로 시동 킴");
	}
	void engineStop () {
		System.out.println("열쇠로 시동 끔");
	}
}

class SuperCar extends Car{
	String mode;

	public SuperCar() {
	}
	
	public SuperCar(String brand, String color, int price, String mode) {
		super(brand, color, price);
		this.mode = mode;
	}
	
	
	void changeMode (String newMode) {
		this.mode =newMode;
		System.out.println("모드가 바뀌었습니다.");
	}
	
	@Override
	void engineStart() {
		System.out.println("음성으로 시동 킴");
	}
	
	@Override
	void engineStop() {
		System.out.println("음성으로 시동 끔");
	}
}
public class CastingTest {
	public static void main(String[] args) {
		//upcasting
		Car noOptionFerrari = new SuperCar();
		//부모타입으로 자식 생성자를 호출함. 
//		noOptionFerrari.engineStart();
		//자식클래서에서 재정의된 메소드가 사용된다. 
		//changeMode는 못쓴다. 왜냐하면 자식클래스에서 새로 선언된 것이기 때문이다. 
		
		//downcasting
		//가장 많이하는 실수
//		SuperCar brokenCar = (SuperCar) new Car();
		//강제 형변환. (클래스는 타입이다.)
		//문법상으로는 이상이 없지만, 실행이 되지 않는다! 
		
		Car car = new Car();
		SuperCar ferrari = new SuperCar();
		
		if (car instanceof Car) {
			System.out.println("nice casting");
		} else {
			System.out.println("err : wrong casting");
		}
		
		if (ferrari instanceof Car) {
			System.out.println("nice casting");
		}else {
			System.out.println("err : wrong casting");
		}
		
		if (car instanceof SuperCar) {
			System.out.println("nice casting");
		}else {
			System.out.println("err : wrong casting");
		}
		
		if (noOptionFerrari instanceof Car) {
			System.out.println("nice casting");
		}else {
			System.out.println("err : wrong casting");
		}
		
		if (noOptionFerrari instanceof SuperCar) {
			System.out.println("nice casting");
		}else {
			System.out.println("err : wrong casting");
		}
		//noOptionFerrari는 SuperCar 타입이기도 하다. 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
