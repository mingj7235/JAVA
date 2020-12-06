package sec08.exam01_threadgroup;

import java.util.Map;
import java.util.Set;

public class ThreadInfoEx {
	public static void main(String[] args) {
		AutoSaveThread autoSaveThread = new AutoSaveThread();
		autoSaveThread.setName("AutoSaveThread"); //이름부여
		autoSaveThread.setDaemon(true);
		autoSaveThread.start();
		
		Map <Thread, StackTraceElement[]> map = Thread.getAllStackTraces(); 
																				//t스텍에있는 모든 쓰레드의 정보를 가져오라는 것임 얘는 Map타입으로 리턴됨
		Set <Thread> threads = map.keySet();
		
		for (Thread thread : threads) {
			System.out.println("Name : " + thread.getName() + (thread.isDaemon() ? "(데몬)" : "(메인)"));
			System.out.println("\t "+ "소속 그룹 : "  + thread.getThreadGroup().getName());
			System.out.println();
		}
		/* 결과값임 (즉, 메인스레드뿐 아니라 다른 스레드도 다 같이 실행중임)     
		 *	Name : AutoSaveThread(데몬)
				 소속 그룹 : main // 이유 : 메인메소드에 AutoSaveThread를 객체화 했으므로
			
			Name : Finalizer(데몬)
				 소속 그룹 : system
			
			Name : Attach Listener(데몬)
				 소속 그룹 : system
			
			Name : Reference Handler(데몬)
				 소속 그룹 : system
			
			Name : Signal Dispatcher(데몬)
				 소속 그룹 : system
			
			Name : main(메인)
				 소속 그룹 : main
		 */
		
		
	}	
}
