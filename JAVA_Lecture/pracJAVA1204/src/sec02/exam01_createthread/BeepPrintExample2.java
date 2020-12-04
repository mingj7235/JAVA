package sec02.exam01_createthread;

import java.awt.Toolkit;

public class BeepPrintExample2 {
	public static void main(String[] args) {
		//main 메소드는 JVM이 생성한 메인스레드에 있어서 자동적으로 실행한다.
		
		//how1 ) 정석적 방법 //다른 클래스를 만들어야한다. 
//		Runnable beeptask = new BeepTask();
//		Thread thread = new Thread(beeptask);
		
		//how2) 익명객체 활용
//		Thread thread = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				//비프음을 5번 반복해서 소리나게 하는 작업
//				Toolkit toolkit = Toolkit.getDefaultToolkit();
//				for (int i = 0; i < 5; i++) {
//					toolkit.beep();
//					try {
//						Thread.sleep(500);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		});
		
		//how3) 람다식
		Thread thread = new Thread ( () -> {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			for (int i = 0; i < 5; i++) {
				toolkit.beep();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
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
