package sec08.exam01_threadgroup;

public class WorkThread extends Thread{
	public WorkThread (ThreadGroup threadGroup, String threadName) {
		super(threadGroup, threadName); //부모인 Thread의 생성자에 넣는 것임. 
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) { 
				System.out.println(getName() + " interrupted");
				break;
			}
		}
		System.out.println(getName() + " 종료됨");
	}
}
