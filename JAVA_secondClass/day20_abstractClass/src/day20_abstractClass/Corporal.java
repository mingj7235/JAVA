package day20_abstractClass;

public class Corporal implements Soldier{

	@Override
	public void eat() {
		System.out.println("편하게 먹는다.");
	}

	@Override
	public void work() {
		System.out.println("능숙하게 한다.");
	}

	@Override
	public void play() {
		System.out.println("제일 많이 논다.");
	}

	@Override
	public void sleep() {
		System.out.println("많이 잔다.");
	}

	@Override
	public void salute() {
		System.out.println("ㅊㅅ!");
	}

}
