package THREAD;

public class Come implements Runnable{
	@Override
		public void run() {
			come();
		}
	
	
//	@Override
//	public void run() {
//		come();
//		super.run();
//	}
	
	public void come () {
		while (true) {
			System.out.println("come!");
		}
	}
}
