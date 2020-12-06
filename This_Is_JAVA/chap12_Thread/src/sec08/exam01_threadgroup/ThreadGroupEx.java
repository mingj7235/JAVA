package sec08.exam01_threadgroup;

public class ThreadGroupEx {
	public static void main(String[] args) {
		ThreadGroup myGroup = new ThreadGroup("myGroup");
		WorkThread workThreadA = new WorkThread(myGroup, "workThreadA");
		WorkThread workThreadB = new WorkThread(myGroup, "workThreadB");
																						//소속그룹, 스레드이름
		
		workThreadA.start();
		workThreadB.start();
		
		System.out.println("[main 스레드 그룹의 list() 메소드 출력 내용]");
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup(); //현재 스레드 그룹
		mainGroup.list(); // 리스트를 호출함 안에있는 상태에대한 출력
		System.out.println();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		System.out.println("[myGroup 스레드 그룹의 interrupt()메소드 호출]");
		//myGroup에있는 건 workThreadA, workThreadB가있음
		
		myGroup.interrupt(); //이렇게되면 그 안에 속한 모든 스레드가 인터럽되면서 종료됨
		
		/*
		 * [main 스레드 그룹의 list() 메소드 출력 내용]
			java.lang.ThreadGroup[name=main,maxpri=10]
																		//가질수있는 최대 우선순위는 10임
			    Thread[main,5,main]
			    			//스레드이름, 우선순위, 소속 그룹이름
			    java.lang.ThreadGroup[name=myGroup,maxpri=10]
			        Thread[workThreadA,5,myGroup]
			        Thread[workThreadB,5,myGroup]
		 * 
		 * [myGroup 스레드 그룹의 interrupt()메소드 호출]
			workThreadA interrupted
			workThreadB interrupted
			workThreadB 종료됨
			workThreadA 종료됨
		 */
		
		
	}
}
