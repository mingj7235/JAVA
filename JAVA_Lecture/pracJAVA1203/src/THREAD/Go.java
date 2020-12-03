package THREAD;

public class Go implements Runnable{
	
	@Override
	public void run() {
		go();
	}
	
//	@Override
//	public void run() { //스레드로 처리할 내용을 작성
//		go();
//		super.run();
//	}
	public void go () {
		while (true) {
			System.out.println("Go!");
		}
	}

}
