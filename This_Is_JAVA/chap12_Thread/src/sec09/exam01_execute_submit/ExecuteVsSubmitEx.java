package sec09.exam01_execute_submit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecuteVsSubmitEx {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		//스레드풀 생성. 최대 스레드수가 2개임
		
		for (int i = 0; i <10 ; i ++) {
			//작업정의
			Runnable runnable = new Runnable () {
				@Override
				public void run() {
					ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
					int poolSize = threadPoolExecutor.getPoolSize(); //스레드풀에 있는 스레드 수
					
					String threadName = Thread.currentThread().getName();
					System.out.println("[총 스레드 개수 : " + poolSize + "]" +
							"작업 스레드 이름 -" + threadName); //작업 처리 -pool-1-thread-1
					
					//예외발생시키기
					int value = Integer.parseInt("삼"); //numberformat exception 발생
					
				}
			};
			//작업 Queue에 넣기 (execute)
//			executorService.execute(runnable); // -> 작업 Queue에 작업이 저장됨 
			// execute는 예외발생하면 스레드를 스레드풀에서 제거하고 새로운 스레드를 만든다. 
			
			//작업 Queue에 넣기 (submit)
			executorService.submit(runnable);
			//submit은 예외발생하면 예외를 발생시키지 않고 스레드를 스레드풀에서 제거하지 않고 다음작업으로 넘어가 재사용한다. 
			
			try {
				Thread.sleep(10); //포문이 너무 빨리 돌아서 예외 콘솔 출력이 제대로 되지 않기에 슬립을 걸어준다. 
			} catch (InterruptedException e) {}
		}
		
		//작업 종료
		executorService.shutdown(); //shutdown()은 작업을 모두 다 처리한 후 스레드풀 종료
	}
}
