package day33_Thread;

public class Th extends Thread{
	
	public Th(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(super.getName()+" thread. i =" + i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Th thread1 = new Th("first");
		Th thread2 = new Th("second");
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("main 종료");
		
		//main도 thread다. (개중요!) 
		//즉, 가장 먼저 실행되는 thread는 main이기때문에 sleep을 주지 않으니까
		//이클립스에 밑에있는 문장이라도 먼저 실행이 된다. 
		//그래서 join() 이라는 메소드를 써주어서 안정적으로 로직이 위에서 아래로 진행되도록 해준다. 엉키지 않는다.
		//thread 끝난다음에 다음 thread가 실행될 수 있도록 join을 걸어주는 것이다.
		//그렇게하면, 위의 로직이 끝나면 아래의 로직이 실행된다. 
		//join 도 thread를 잠시 멈추는 것이기때문에 InterruptedException이 일어날수있으니 예외처리를 해준다.
		
		/*
		 * join()
		 * 쓰레드 사용시 쓰레드 종료 전에 다른 로직 수행시 치명적인 예기치 못한 오류가 발생한다.
		 * 그러므로 join() 사용시 밑에 로직들은 쓰레드가 종료 될 때까지 기다린 후 실행된다.  
		 * 
		 */

		
		
	}
}
