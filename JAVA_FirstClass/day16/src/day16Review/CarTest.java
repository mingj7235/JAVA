package day16Review;



public class CarTest {
	public static void main(String[] args) {
		SuperCar superCar = new SuperCar();
		//기본생성자를 호출했을 때만 부모 클래스를 가져온다.
		
		SuperCar ferrari = new SuperCar("Ferrari", "Red", 45000, "sport");
		System.out.println(ferrari);
		
		ferrari.engineStart();
		ferrari.engineStop();
		
		//모든 클래스는 object 클래스를 상속받는다. 
		
	}
}
