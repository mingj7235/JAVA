package sec02.exam02_threadname;

public class ThreadnameEx {
	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		System.out.println("프로그램 시작 스레드 이름 : " + mainThread.getName());
		
		Thread threadA = new ThreadA ();
		threadA.start();
	}
}
