package pb;

public class BreadPlate {
	
	private int breadCnt = 0;
	// 빵먹는 갯수
	public static int cnt = 1;
	
	public synchronized void makeBread () {
		//synchronized가 붙은애들끼리 동기화가 된다. 
		if (breadCnt > 9) {
			System.out.println("빵이 가득 찼습니다.");
			try {
				wait();
				//wait() 는 Object에 있는 메서드다. 그냥 쓸수있음.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			breadCnt++;
			System.out.println("빵을 1개 만들었습니다. 총 : " +breadCnt + "개");
		}
	}
	
	public synchronized void eatBread() {
		if (cnt == 20) {
			System.out.println("빵이 다 떨어졌습니다.");
			
		} else if (breadCnt <1) {
			System.out.println("빵이 없습니다. 만들 때 까지 기다려주세요");
		} else {
			breadCnt--;
			cnt++;
			System.out.println("빵을 1개 먹었습니다. 총 : " + breadCnt + "개");
			if (breadCnt<10) {
				this.notify();
			}
		}
	}
	
	
}
