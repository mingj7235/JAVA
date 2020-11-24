package day20_abstractClass;

public class Sergeant extends SoldierAdapter {
	
	//이게 추상클래스와 인터페이스의 활용방법. 
	
	@Override
	public void play() {
		System.out.println("계속 논다.");
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
