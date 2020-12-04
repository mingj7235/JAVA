package sec04.exam01_unsynchronized;

public class User02 extends Thread{
	
	private Calculator calculator;

	public void setCalculator(Calculator calculator) {
		this.setName("User02");
		this.calculator = calculator;
	}
	@Override
	public void run() {
		calculator.setMemory(50);
	}
}
