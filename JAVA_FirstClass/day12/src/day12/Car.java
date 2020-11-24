package day12;

public class Car {
	int price;
	String color;
	String brand;
	//Overloading
	//이게 생성자다. Car(){}
	Car(){}
	
	//생성자는 메서드와 같기때문에 외부에서 매개변수들을 받아오는거다.
	//Car 생성자 매개변수 안에있는건 지역변수다. 
	public Car(int price, String color, String brand) {
		this.price = price;
		this.color = color;
		this.brand = brand;
	}
	
	double speedUp(double speed){
		speed++;
		return speed;
		
	}
	double speedDown (double speed){
		speed--;
		return speed;
		
	}
	void showInfo() {
		//그 주소에 있는.. this. 를 찾아가라 .
		System.out.println(this);
		System.out.println("브랜드 : " + brand + "\n색상 : " + color + "\n가격 : " + price + " 만원");
	}
	
	public static void main(String[] args) {
		//객체화
		//momcar와 같은걸 인스턴스 변수 (객체) 라고 한다. (instance : 실체!! 라고 받아들이면됨. 예시!!. 예를들면 실제로 이해하기편하니까..) 라는 의미임. 
		//즉, 인스턴스 변수라는 것은 예를든다, 즉 공표한다 라는 의미라고 받아들이면 될듯
		
		//클래스명 () : 기본 생성자 => 클래스를 선언하면 자동으로 선언되는 생성자. Car라는 클래스를 만들었으니 Car(); 생성자가 자동적으로 선언된다.(생성된다)
		//우리가 임의로 생성자를 선언하면 그 임의로 생성한 생성자가 기본생성자가된다. 
		//생성자는 리턴타입이 없는 메서드. 메서드랑은 다르다!! 
		//생성자는 초기화의 목적이 있다. 클래스명() 의 형태다.
		//메서드와 같은 기능을 가지고 있지만, 리턴이 없으며, 리턴타입도 없다.
		//따라서 메서드라고 부르지 않는다. !!!! 
		
		Car momcar = new Car(9000,"Black","Benz");
		momcar.showInfo();
		Car dadcar = new Car();
		Car mycar = new Car();
		
//		momcar.brand = "Benz";
//		momcar.color = "Black";
//		momcar.price = 9000;
//		momcar.showInfo();
//		System.out.println(momcar);
//		
//		momcar.brand = "Hyundai";
//		momcar.color = "white";
//		momcar.price = 6700;
//		dadcar.showInfo();
//		
		
	}
}

