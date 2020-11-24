package day16;

public class CarTest {
	public static void main(String[] args) {
//		Object
		SuperCar supercar = new SuperCar();
		SuperCar ferrari = new SuperCar("ferrari", "Red", 45000, "sport");
		//자식클래스의 기본생성자로 초기화해줬을 때만 부모클래스의 생성자를 찍고온다. 
		System.out.println(ferrari);
//		System.out.println(ferrari.toString);
		//.toString 은 주소를 출력하는 object 클래스의 메서드다.
		//이걸 재정의해보자. toString은 생략가능하므로 내가 재정의한 걸 출력할 수있게한다.
		//이게 왜편하냐면 객체 이름만 출력했을 때 원래는 주소값이 나오는데
		//toString을 재정의했으므로 (SuperCar클래스에서) 객체명만 출력했을때
		//객체의 정보를 담을 수 있다. 
		ferrari.engineStart();
		ferrari.engineStop();
	}
}
