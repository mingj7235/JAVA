package sec07.exam01_daemon;

public class DaemonEx {
	public static void main(String[] args) {
		AutoSaveThread autoSaveThread = new AutoSaveThread();
		autoSaveThread.setDaemon(true); //main스레드의 데몬 스레드로 만든것임
		autoSaveThread.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}
		System.out.println("메인 스레드 종료 ");
	}
}
