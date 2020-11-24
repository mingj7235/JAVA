package day35_Timecheck;

public class TimeCheck {
	public static void main(String[] args) {
		//보통 시간을 담을 때는 long 에 담는다. 
		
		long start = System.currentTimeMillis();
		//현재 시간을 밀리초로 나타낸 것
		long end = 0L;
		
		int ar[] = new int [10000000];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = i;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		end = System.currentTimeMillis();
		System.out.println((end-start)/1000.0+"초");
		
	}
}
