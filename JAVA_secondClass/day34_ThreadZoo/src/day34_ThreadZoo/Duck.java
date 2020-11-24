package day34_ThreadZoo;

public class Duck implements Runnable{

	void sound_duck() {
		System.out.println("Ва~Ва!");
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			sound_duck();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
}
