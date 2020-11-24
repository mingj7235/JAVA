package p1;

public class PhoneMain {
	public static void main(String[] args) {
		//SmartPhone 객체화
		SmartPhone S20 = new SmartPhone();
		
		//SmartPhone 다형성
		//참조타입을 부모로, 객체는 자식으로
		Phone Snote20 = new SmartPhone();
		
		//Phone 객체화 => 추상클래스는 객체화 할수가 없다. 
//		Phone iphone12 = new Phone(); 
		
	}
}
