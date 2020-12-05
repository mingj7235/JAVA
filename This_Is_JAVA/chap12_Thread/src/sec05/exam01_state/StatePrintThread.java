package sec05.exam01_state;

public class StatePrintThread extends Thread{
	private Thread targetThread;

	public StatePrintThread(Thread targetThread) {
		this.targetThread = targetThread;
	}
	@Override
	public void run() {
		while (true) {
			Thread.State state = targetThread.getState();
			//targetThread 의 현재 상태를 말해줌
			//State 의 열거 상수에 스레드들의 상태들이 있음. ex> Blocked, new, runnable...
			System.out.println("타겟 스레드 상태 : " + state);
			if (state == Thread.State.NEW) {
				targetThread.start();
			}
			if (state == Thread.State.TERMINATED) {
				break;
			} 
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}
}
