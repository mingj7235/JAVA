package sec02.exam01_createthread;

import java.awt.Toolkit;

public class BeepPrintExample3 {
	public static void main(String[] args) {
		//thread 하위 객체로 생성하는법
		//how1 //Thread를 extends 받은 클래스를 객체화
//		Thread thread = new BeepThread();
//		thread.start();
		
		//how2 //익명객체로 만드는법
		
		Thread thread = new Thread() {
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for (int i = 0; i < 5; i++) {
					toolkit.beep();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		
		thread.setName("좋은스레드");
		System.out.println(thread.getName());
		thread.start();
		//"띵" 이라는 문자열을 5번 출력하는 작업
		for (int i = 0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
