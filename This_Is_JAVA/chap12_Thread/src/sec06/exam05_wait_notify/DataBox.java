package sec06.exam05_wait_notify;

public class DataBox {
	//공유 객체
	private String data;

	public synchronized String getData() {
		if (this.data == null) {
			//null인경우 소비자 스레드를 wait시킴
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		String returnValue = data;
		System.out.println("Consummer Thread가 읽은 데이터 : " + returnValue);
		data = null;
		notify(); //생산자 스레드를 호출함 
		return returnValue;
	}
	
	public synchronized void setData(String data) {
		if (this.data != null) {
			//소비자 스레드가 아직 데이터를 읽지 않았다면
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		
		this.data = data;
		System.out.println("Producer Thread가 생성한 데이터 " + data);
		notify(); // 소비자 스레드를 깨움
	}
	
	
}
