package sec04.exam01_unsynchronized;

public class MainThreadEx {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		
		User01 u1 = new User01();
		u1.setCalculator(calculator);
		u1.start();

		User02 u2 = new User02();
		u2.setCalculator(calculator);
		u2.start();
		
	}
}
