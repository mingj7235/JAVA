package ThreadQuestion;

public class Producer extends Thread{
	private SharedThread st;

	public Producer(SharedThread st) {
		this.st = st;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			st.movie();
		}
	}
}
