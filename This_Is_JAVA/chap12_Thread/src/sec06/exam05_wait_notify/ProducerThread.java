package sec06.exam05_wait_notify;

public class ProducerThread extends Thread{
	private DataBox databox;

	public ProducerThread(DataBox databox) { 
		this.setName("Producer Thread");
		this.databox = databox;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			String data = "Data-" + (i+1);
			databox.setData(data);
		}
	}
}
