package sec06.exam03_join;

public class JoinExample {
	public static void main(String[] args) {
		SumThread sumThread = new SumThread();
		
		sumThread.start();
		try {
			sumThread.join();
		} catch (InterruptedException e) {	} 
		
		//join()을 사용하여 기다려주는 것임. 
		
		System.out.println("1~100까지의 합 : " + sumThread.getSum()); 
		//join() 없이 출력하면, 중간의 값이 출력이 되는 것이다. run() 도중에 출력됨. 
		//join()을 사용하여 결과 값을 얻을 수있도록 출력하는 것임
		
		
		
	}
}
