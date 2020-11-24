package day34_ThreadZoo;

public class Zoo {
	public static void main(String[] args) {
		//멀티스레드의 기본 응용 예제
		Cat cat = new Cat();
		Duck duck = new Duck();
		Pig pig = new Pig();
		
		Thread t1 = new Thread(cat);
		Thread t2 = new Thread(duck);
		Thread t3 = new Thread(pig);
				
		t1.start();
		t3.start();
		
		try {
			t1.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t2.start();
	}
}
