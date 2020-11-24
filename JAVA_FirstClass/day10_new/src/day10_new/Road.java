package day10_new;
class Car {
	//브랜드, 색상, 가격
	String brand;
	String color;
	int price;
	boolean isOn;
	//기본생성자
	
	public Car() {	}
	//초기화생성자
	
	public Car(String brand, String color, int price) {
		super();
		//Car는 상속받은게 없는데 왜 super() 가 있는 것일까?
		//모든 클래스는 Object라는 클래스를 상속받는다. Object는 최상위 부모 클래스다.
		//그렇기 때문에 이 super()는 Object 클래스의 생성자다. 
		System.out.println("부모 생성자 호출됨");
		this.brand = brand;
		this.color = color;
		this.price = price;
	}
	//시동은 열쇠로 킴, 끔 println으로 출력하기
	//시동켜기
	
	void engineStart() {
		if (!isOn) {
			isOn = true;
			System.out.println("열쇠로 시동킴");
		}else {
			System.out.println("시동이 켜져있습니다.");
		}
	}
	//시동끄기
	void engineStop() {
		if (isOn) {
			isOn = false;
			System.out.println("열쇠로 시동끔");
		}else {
			System.out.println("시동이 꺼져있습니다.");
		}
	}
}

class SuperCar extends Car{
	String mode;

		//단축키 !!! alt shift s + o 한다음에 맨위에 invoke 확인.!!! 이거 블로그
	public SuperCar(String brand, String color, int price, String mode) {
//		System.out.println("자식 생성자 호출됨");
		//이렇게 자식의 소스코드가 올라가면 오류가 생김
		super(brand, color, price);
		System.out.println("자식 생성자 호출됨");
		//그래서 super 밑에 쓰는 것임.
		this.mode = mode;
	}
	
	@Override
	void engineStart() {
		System.out.println("음성으로 시동 킴");
		//부모의 메소드 호출
		super.engineStart();
		//super에 마침표를 찍었으니 부모것. 부모것을 가지고 오는것이다. 누적합을 해주는 것이다.
		//기존의 것을 호출해준것이다.
	}	
	
	@Override
	void engineStop() {
		System.out.println("음성으로 시동 끔");
	}

	void openRoof () {
		System.out.println("뚜껑 열림");
	}
	
	void closeRoof () {
		System.out.println("뚜껑 닫힘");
	}
}
public class Road {
	public static void main(String[] args) {
//		Car myCar = new Car();
		SuperCar ferrari = new SuperCar("Ferrari", "RED", 44000, "Daily");
//		myCar.engineStart();
//		myCar.engineStart();
//		myCar.engineStop();
//		myCar.engineStop();
//		
		//부모생성자가 무조건 먼저 호출된다. 
		
		ferrari.engineStart();
		ferrari.engineStart();
		
	}
}


