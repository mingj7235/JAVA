package p5;

public class CarExample {
	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.run();
		System.out.println("===========");
		myCar.frontLeftTire = new KumhoTire();
		myCar.frontRightTire = new KumhoTire();
//		myCar.backLeftTire = new HankookTire();
//		myCar.backRightTire = new HankookTire();
		myCar.run();
	}
}
