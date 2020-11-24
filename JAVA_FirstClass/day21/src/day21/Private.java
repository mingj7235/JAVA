package day21;

public class Private implements Soldier{

	@Override
	public void eat() {
		System.out.println("90도로 허리와 하단을 만든 후 숟가락을 직각으로 펼치며 식사한다.");
	}

	@Override
	public void work() {
		System.out.println("마치 일을 안하면 안되는 것 처럼 아주 열심히 뛰며 일한다.");
	}

	@Override
	public void play() {
		System.out.println("선임들과 함께 하고 싶으나, 아직 일이 덜 끝났을 때에는 잘 쉬지 못한다.");
	}

	@Override
	public void sleep() {
		System.out.println("불침번을 서기 전까지 아주 잘 잔다.");
	}

	@Override
	public void salute() {
		System.out.println("충~~~~~~~~~~~~~~~~~~~~~~성!");
	}

}
