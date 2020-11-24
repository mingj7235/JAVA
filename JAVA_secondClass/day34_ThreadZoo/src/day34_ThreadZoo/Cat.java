package day34_ThreadZoo;

public class Cat implements Runnable{
	
	void sound_cat() {
		System.out.println("¾ß¿Ë~");
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			sound_cat();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
