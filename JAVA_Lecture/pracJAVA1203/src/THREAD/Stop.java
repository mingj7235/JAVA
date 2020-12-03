package THREAD;

public class Stop implements Runnable {
	
	public void stopM () {
		while(true) {
			System.out.println("stop!");
			
		}
	}

	@Override
	public void run() {
		stopM();
	}

}
