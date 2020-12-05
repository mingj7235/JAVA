package sec06.exam04_wait_notify;

public class WorkObject {
	//공유객체 
	//notify와 wait를 사용하기 위해서는 사용 메소드가 동기화 메소드여야한다! 
	public synchronized void methodA () {
		System.out.println("ThreadA의 methodA() 작업실행");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {}
	}
	
	public synchronized void methodB () {
		System.out.println("ThreadB의 methodB() 작업실행");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {}
		
	}
}
