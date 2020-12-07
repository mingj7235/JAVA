package ThreadQuestion;

public class Consumer extends Thread{
	private SharedThread st;

	public Consumer(SharedThread st) {
		this.st = st;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			st.music();
		}
	}
}
