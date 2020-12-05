package sec05.exam01_state;

public class ThreadStateEx {
	public static void main(String[] args) {
		StatePrintThread statePrintThread = new StatePrintThread(new TargetThread());
		statePrintThread.start();
		
		/* 타겟 스레드 상태 : NEW
		  	타겟 스레드 상태 : RUNNABLE //targetThread의 10억번 반복문
			타겟 스레드 상태 : TIMED_WAITING //여기서 1.5초동안 time sleep
			타겟 스레드 상태 : TIMED_WAITING
			타겟 스레드 상태 : TIMED_WAITING
			타겟 스레드 상태 : RUNNABLE // timep sleep후 다시 10억번 반복
			타겟 스레드 상태 : TERMINATED
			*/
	}
}
