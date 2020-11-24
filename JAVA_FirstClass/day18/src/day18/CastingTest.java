package day18;

class Car {
	String brand;
	String color;
	int price;
	
	public Car() {
	}
	
	public Car(String brand, String color, int price) {
		this.brand = brand;
		this.color = color;
		this.price = price;
	}
	
	void engineStart ()	{
		System.out.println("열쇠로 시동 킴");
	}
	
	void engineStop ()	{
		System.out.println("열쇠로 시동 끔");
	}
}

class SuperCar extends Car {
	String mode;

	public SuperCar() {
	}

	public SuperCar(String brand, String color, int price, String mode) {
		super(brand, color, price);
		this.mode = mode;
	}
	
	void changeMode (String newMode) {
		this.mode = newMode;
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
		Car noOptionFerrari = new SuperCar () ;
		
//		noOptionFerrari.engineStart();
		//자식에서 재정의된 기능이 들어간다. 단, 자식에서 새로 만들어진 기능은 나오지 않는다.
		
//		//down casting : 오류다 !!!실행하기전까지는 컴파일러가 모르지만, 실행하면 오류가 난다. 
//		SuperCar brokenCar = (SuperCar) new Car();
//		//강제 형변환 해줌
//		brokenCar.changeMode("스포츠");
//		//작동안함... 이거 안됨.. 
		
		Car car = new Car ();
		SuperCar ferrari = new SuperCar();
		
		if (car instanceof Car) {
			System.out.println("nice casting");
			
		}else {
			System.out.println("wrong casting");
			
		}
		
		if (ferrari instanceof Car) {
			System.out.println("nice casting");
			
			//ferrari는 SuperCar 클래스인데, SuperCar는 Car를 상속받았으므로 Car 타입이기도하다. 
		}else {
			System.out.println("wrong casting");
		}
		
		if (car instanceof SuperCar) {
			System.out.println("nice casting");
			
		}else {
			System.out.println("wrong casting");
		}
		
		if(noOptionFerrari instanceof Car) {
			System.out.println("nice casting");
			//타입은 Car 이지만 자식생성자를 호출했다. 하지만 Car타입이 맞다. upcasting을 해도 자식생성자에 추가한 필드를 사용못함.
			//그렇기때문에 Car타입에서 좁혀지지 않는다. 
		}else {
			System.out.println("wrong casting");
		}
		if (noOptionFerrari instanceof SuperCar) {
			System.out.println("nice casting");
			//SuperCar 타입도 맞다. 
		}else {
			System.out.println("wrong casting");
		}
		
		
		
	}
	
	
}
