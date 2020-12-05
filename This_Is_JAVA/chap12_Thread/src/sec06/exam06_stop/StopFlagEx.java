package sec06.exam06_stop;

public class StopFlagEx {
	public static void main(String[] args) {
		PrintThread1 printThread = new PrintThread1();
		printThread.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		
		printThread.setStop(true);
		
		//1초뒤에 종료가된다. stop이라는 플래그를 이용!
	}
}
