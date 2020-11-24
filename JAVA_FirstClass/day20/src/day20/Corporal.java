package day20;

public class Corporal implements Soldier{

	@Override
	public void eat() {
		System.out.println("밖의 경치를 보며 여유롭게 식사한다.");
	}

	@Override
	public void work() {
		System.out.println("업무 지시를 한다.");
	}

	@Override
	public void play() {
		System.out.println("달려간다.");
	}

	@Override
	public void sleep() {
		System.out.println("세상 모르게 잔다.");
	}

	@Override
	public void salute() {
		System.out.println("충ㅅ");
	}

}
