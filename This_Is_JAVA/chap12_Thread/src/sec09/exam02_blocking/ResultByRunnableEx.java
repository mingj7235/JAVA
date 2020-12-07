package sec09.exam02_blocking;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultByRunnableEx {
	//runnable을 사용하여 외부객체에 저장하기
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors()
				);
		
		System.out.println("[작업 처리 요청]");
		class Task implements Runnable {
			Result result;
			
			public Task(Result result) {
				this.result = result;
			}
			@Override
			public void run() {
				int sum = 0;
				for (int i = 0; i < 10; i++) {
					sum += (i+1);
				}
				result.addValue(sum);
			}
		};
		
		//공유객체 (외부객체)-> 스레드들이 공유하는 객체 
		Result result = new Result();
		//두개의 작업을 정의
		Runnable task1 = new Task(result);
		Runnable task2 = new Task(result);
		
		//작업 Queue에 넣고 외부객체를 지정함. 
		Future <Result> future1 = executorService.submit(task1, result);
		Future <Result> future2 = executorService.submit(task2, result);
		
		try {
			result = future1.get();
			result = future2.get();
			System.out.println("[처리결과 ]" + result.accumValue); //task1 과 task2가 모두 총합된 결과임
			System.out.println("[작업 처리 완료]");
		} catch (Exception e) {
			System.out.println("[실행 예외 발생함]" +e.getMessage());
		} 
	}
}
class Result {
	int accumValue;
	synchronized void addValue(int value) { //동기화 메소드로 호출하기
		accumValue += value;
	}
}
