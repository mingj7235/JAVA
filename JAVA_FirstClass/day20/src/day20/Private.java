package day20;

public class Private implements Soldier{

	@Override
	public void eat() {
		System.out.println("천천히 각을 재서 90도로 앉아서 먹는다.");
	}

	@Override
	public void work() {
		System.out.println("아주 열심히 일하지만 결과물이 없다.");
	}

	@Override
	public void play() {
		System.out.println("안타깝게도 남은 일들이 많아서 꿈에서 논다.");
	}

	@Override
	public void sleep() {
		play();
		System.out.println("잠에 들지 못한다.");
	}

	@Override
	public void salute() {
		System.out.println("충!!!!!!!!!!!!!!!성!!!!!!!!!!!!!!!!");
	}

}
