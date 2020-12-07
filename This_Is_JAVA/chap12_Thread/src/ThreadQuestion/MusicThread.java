package ThreadQuestion;

public class MusicThread extends Thread{
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("음악을 재생합니다");
		}
	}
}
