package day21;

public class Corporal implements Soldier{

	@Override
	public void eat() {
		System.out.println("편하게 먹는다.");
	}

	@Override
	public void work() {
		System.out.println("잘 안한다. 하지만 책임감을 가지고 후임들을 관리한다.");
	}

	@Override
	public void play() {
		System.out.println("신나게 논다. 취미활동이 생긴다.");
	}

	@Override
	public void sleep() {
		System.out.println("잠을 잘 못잔다. 이미 낮에 잤기 때문이다.");
	}

	@Override
	public void salute() {
		System.out.println("ㅊㅅ");
	}
}
