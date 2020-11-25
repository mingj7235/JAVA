package p2_TireEx_Polymorphism;

public class CarExample {
	public static void main(String[] args) {
		Car car = new Car();
		
		for (int i = 1 ; i <=8 ; i ++) {
			int problemLocation = car.run();
			switch (problemLocation) {
			case 1 : 
				System.out.println("앞 왼쪽 한국타이어로 교체");
				car.frontLeftTire = new HankookTire("앞 왼쪽", 15);
				//부모클래스 참조변수 = new 자손클래스(); => 요것이 다형성!!!!
				//car.frontLeftTire 도역시 Tire 클래스의 참조변수다. 
				break;
			case 2 : 
				System.out.println("앞 오른쪽 금호타이어로 교체");
				car.frontRightTire = new KumhoTire("앞 오른쪽", 13);
				break;
			case 3 : 
				System.out.println("뒤 왼쪽 미쉐린타이어로 교체");
				car.backLeftTire = new MichelinTire("뒤 왼쪽", 18);
				break;
			case 4 : 
				System.out.println("뒤 오른쪽 넥센타이어로 교체");
				car.backRightTire = new NexenTire("뒤 오른쪽", 21);
				break;
			}
			System.out.println("--------------------");
		}
		
	}
}
