package day20;

public class Pfc implements Soldier{

	@Override
	public void eat() {
		System.out.println("조금 빨리 식사를 하고 후임들을 챙겨야 한다.");
	}

	@Override
	public void work() {
		System.out.println("점점 일을 마치고 결과물이 생기고, 후임들 일도 도맡아 한다.");
	}

	@Override
	public void play() {
		System.out.println("개인정비시간을 잘 활용하여 사지방과 노래방을 갈 수 있다.");
	}

	@Override
	public void sleep() {
		System.out.println("잠에 잘 들지만 아침 6시 30분에 눈이 떠진다.");
	}

	@Override
	public void salute() {
		System.out.println("충!성!");
	}

}
