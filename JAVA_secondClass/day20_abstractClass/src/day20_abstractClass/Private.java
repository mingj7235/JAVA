package day20_abstractClass;

public class Private implements Soldier {
	@Override
	public void eat() {
		System.out.println("불편하게 먹는다.");
	}

	@Override
	public void work() {
		System.out.println("개열심히 한다");
	}

	@Override
	public void play() {
		System.out.println("못논다.");
	}

	@Override
	public void sleep() {
		System.out.println("불침번 서야한다.");
	}

	@Override
	public void salute() {
		System.out.println("충!!!!!!!!!!!!!성!!!!!!!!!!");
	}

}
