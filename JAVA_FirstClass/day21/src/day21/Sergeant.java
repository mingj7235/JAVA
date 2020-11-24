package day21;

public class Sergeant extends Army {
	
	//Army 추상클래스에서 구현된 메서드는 일반메서드이므로 그냥 가지고 오면된다. 
	
	@Override
	public void play() {
		System.out.println("계속 논다. ");
	}
	
	@Override
	public void sleep() {
		System.out.println("계속 잔다.");
	}
	@Override
	public void salute() {
		System.out.println("ㅊ");
	}
	
}
