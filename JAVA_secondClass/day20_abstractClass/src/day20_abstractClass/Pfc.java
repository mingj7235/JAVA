package day20_abstractClass;

public class Pfc implements Soldier{

	@Override
	public void eat() {
		System.out.println("좀 여유있게 먹는다.");
	}

	@Override
	public void work() {
		System.out.println("제일 빠르게 한다.");
	}

	@Override
	public void play() {
		System.out.println("어느정도 여유있게 논다.");
	}

	@Override
	public void sleep() {
		System.out.println("잘잔다.");
	}

	@Override
	public void salute() {
		System.out.println("충!성!");
	}

}
