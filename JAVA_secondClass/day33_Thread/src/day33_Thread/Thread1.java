package day33_Thread;
/*
 * 멀티 쓰레드
 * 
 * Thread 클래스 상속
 * Runnable 인터페이스 구현 (able이 붙으면 interface다) 보통 Runnable을 많이 implements를 해서 쓴다. 
 * 
 * 
 */
public class Thread1 extends Thread{
	String data;
	public Thread1(String data) {
		this.data = data;
	}
	
	@Override
	public void run() {
		//Thread의 핵심 메서드 run
		for (int i = 0; i < 10; i++) {
			System.out.println(data);
			try {
				sleep(500);
				//sleep은 Thread안에 있는 메서드이기때문에 그냥 써도된다. 왜? 상속받았자나 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
