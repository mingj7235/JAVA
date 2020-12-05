package sec06.exam02_yield;

public class YieldEx {
	public static void main(String[] args) {
		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();
		threadA.start();
		threadB.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {	}
		threadA.work =false;
		//A의 work필드가 false가 되므로, yield()가 호출되어 B만 작업한다. 
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {	}
		threadA.work =true;
		//다시 번갈아 반복됨
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {	}
		threadA.stop = true;
		threadB.stop = true;
		
		//stop() 메소드를 사용하지말고, run() 메소드 내에서 조건을 넣고, 필드값을 만들어서 제어해주는것이 
		//안전하다. stop() 메소드는 deprecated되었다. (불안정적임)
	}
}
