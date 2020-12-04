package sec03.exam01_priority;

public class PriorityEx {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Thread thread = new CalcThread("Thread" + (i+1));
			if (i != 9) {
				thread.setPriority(Thread.MIN_PRIORITY);
			}else {
				thread.setPriority(thread.MAX_PRIORITY);
			}
			thread.start();
		}
	}
}
