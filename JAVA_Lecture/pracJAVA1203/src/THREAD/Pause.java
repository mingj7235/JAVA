package THREAD;

public class Pause implements Runnable{


	
	public void pauseM () {
		while (true) {
			System.out.println("Pause !");
		}
	}

	@Override
	public void run() {
		pauseM();
	}
	
}
