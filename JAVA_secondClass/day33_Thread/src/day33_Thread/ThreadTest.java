package day33_Thread;

public class ThreadTest {
	public static void main(String[] args) {
		//Thread 클래스
//		Thread1 th1 = new Thread1("★");
//		Thread1 th2 = new Thread1("♥");
//		th1.start();
//		th2.start();
		//병렬적. start는 그 객체의 run()을 찾는 메서드다. 그 run을 찾아서 동시발생 시키는 메서드다. 
		
		//Runnable 인터페이스
		Thread2 t1 = new Thread2("!");
		Thread2 t2 = new Thread2("?");
		Thread thread1 = new Thread(t1);
		Thread thread2 = new Thread(t2);
		//Runnable로 만든 객체를 Thread 클래스의 생성자에 넣어서 start메서드를 불러야한다.
		
		thread1.start();
		thread2.start();
		
		
		
		
	}
}
