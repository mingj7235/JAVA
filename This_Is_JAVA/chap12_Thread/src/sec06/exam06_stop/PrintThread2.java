package sec06.exam06_stop;

public class PrintThread2 extends Thread{
	@Override
	public void run() {
//		try {
//			while (true) {
//				System.out.println("실행 중");
//				Thread.sleep(1); // 일부러 interrupt를 위해 넣은것임. 이건 그리 좋은방법이 아님
//			}
//		}catch (InterruptedException e) {
//			System.out.println("예외발생");
//		}
		
		while (true) {
			System.out.println("실행중");
			if (Thread.interrupted()) {
//			if (isInterrupted()) { // 이걸 사용해도됨. 
				//interrupted() 가 호출이 된다면 break;해라! 라는 것임.
				break;
			}
		}
		System.out.println("자원 정리");
		System.out.println("실행 종료 ");
	}
}
