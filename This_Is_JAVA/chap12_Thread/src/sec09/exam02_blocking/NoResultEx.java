package sec09.exam02_blocking;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NoResultEx {
	//작업처리 결과가 없는 작업을 blocking 방식으로 
	public static void main(String[] args) {
		//스레드 풀의 최대 스레드수가 cpu의 코어갯수인 스레드풀 생성
		ExecutorService executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors()
				//현재 사용하는 cpu의 코어 갯수 (내컴퓨터는 4개임 쿼드코어)
				);
		
		System.out.println("[작업 처리 요청]");
		Runnable runnable = new Runnable() { //익명개체로 소환!
			@Override
			public void run() {
				//스레드 풀의 스레드가 작업할 내용 작성
				int sum = 0;
				for (int i = 0; i < 10; i++) {
					sum += (i+1);
				}
				System.out.println("[처리결과] " + sum);
			}
		};
		
		//작업 Queue에 저장 -> 스레드 풀의 객체를 이용해서 submit 이나 execute를 사용
		Future future = executorService.submit(runnable); //리턴값이 없어도 submit사용 가능 
	
		//blocking
		//작업이 완료될때까지만 blocking 되고, 작업 결과는 리턴값이 없으므로 null을 리턴함 
		//리턴타입이 Object이라서 Object 객체로 받을 수 있으나, 현재는 null을 리턴하므로 무쓸모. 
		try {
			future.get();
			System.out.println("[작업 처리 완료]");
		} catch (Exception e) {
			//스레드가 인트럽트 되었을 때
			System.out.println("[예외 발생함]" + e.getMessage());
		} 
		
		//스레드풀 종료
		executorService.shutdown();
		
	}
}
