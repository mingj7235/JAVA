package ThreadQuestion;

public class ThreadPlay {
	public static void main(String[] args) {
		SharedThread st = new SharedThread();
		
		Producer thread1 = new Producer(st);
		Consumer thread2 = new Consumer(st);
		
		thread1.setPriority(10);
		thread1.start();
		thread2.start();
		
		
	}
}
