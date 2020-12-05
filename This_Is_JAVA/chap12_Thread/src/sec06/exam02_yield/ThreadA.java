package sec06.exam02_yield;

public class ThreadA extends Thread{
	//stop 은 스레드를 멈추기위해 사용할 예정이고 work는 yield 메소드를 사용한 시점을 알기위해 사용
	public boolean stop = false;
	public boolean work = true;
	
	@Override
	public void run() {
		while (!stop) {
			if(work) {
				System.out.println("ThreadA 작업내용");
			}else {
				//work가 false가 되면 무의미한 반복을 돌기때문에 yield()를 호출함
				Thread.yield();
			}
		}
		System.out.println("ThreadA 종료");
	}
}
