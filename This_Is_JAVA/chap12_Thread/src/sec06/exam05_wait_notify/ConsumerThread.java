package sec06.exam05_wait_notify;

public class ConsumerThread extends Thread{
	private DataBox databox;

	public ConsumerThread(DataBox databox) { 
		this.setName("Consumer Thread");
		this.databox = databox;
	}
	
	@Override
	public void run() {
		for (int i = 0 ; i < 3 ; i++) {
			String data = databox.getData();
			//이용코드 ----
		}
	}
}
