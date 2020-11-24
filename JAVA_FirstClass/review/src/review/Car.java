package review;

public class Car {
	int price;
	String color;
	String brand;
	String name;
	
	//생성자 만들기.
	/*
	 * 생성자는 메서드와 기능이 같다.
	 * 하지만 1. 리턴값이 없고.
	 * 2. 그러므로 리턴타입도 없다.
	 * 3. 명칭이 클래스명 () {} 이므로 앞이 대문자다.
	 * 4. 목적은 초기화에 있다.
	 */
	
	//기본생성자 초기화.
	//이름은 같으나 다른 매개변수로 선언 가능.
	//overLoading
	Car () {
		
	}
	
	public Car(int price, String color, String brand, String name) {
		this.price = price;
		this.color = color;
		this.brand = brand;
		this.name = name;
	}
	
	double speedUp (double speed) {
		speed ++;
		return speed;
	}
	double speedDown (double speed) {
		speed --;
		return speed;

	}
	
	void showInfo () {
		System.out.println(this);
		System.out.println("브랜드 : " + brand + "\n색상 : " + color + "\n가격 : " + price + "만원");
	}
	
	public static void main(String[] args) {
		//객체화
		//momCar, dadCar등을 인스턴스 변수라고 한다. 객체라고도하고.  for instance 를 기억하자. 예시.. 라는 의미. Car 라는 
		//클래스명() : 기본생성자
		//클래스를 선언하면 자동으로 선언되는 생성자
		Car momCar = new Car (9000, "Black", "Benz", "엄마차");
		momCar.showInfo();
		Car dadCar = new Car ();
		Car myCar = new Car ();
		
//		momCar.brand = "Benz";
//		momCar.color = "Black";
//		momCar.price = 9000;
//		momCar.showInfo();
//		System.out.println(momCar);
//		System.out.println(dadCar);

		//생성자는 초기화에 목적이 있다!!!!!!!
		
		
	}
}
