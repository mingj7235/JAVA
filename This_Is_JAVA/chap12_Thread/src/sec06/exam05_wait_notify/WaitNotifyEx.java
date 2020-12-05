package sec06.exam05_wait_notify;

public class WaitNotifyEx {
	public static void main(String[] args) {
		DataBox dataBox = new DataBox();
		
		ProducerThread pt = new ProducerThread(dataBox);
		ConsumerThread ct = new ConsumerThread(dataBox);
		
		pt.start();
		ct.start();
		
		/* 콘솔 출력 내용 
		Producer Thread가 생성한 데이터 Data-1
		Consummer Thread가 읽은 데이터 : Data-1
		Producer Thread가 생성한 데이터 Data-2
		Consummer Thread가 읽은 데이터 : Data-2
		Producer Thread가 생성한 데이터 Data-3
		Consummer Thread가 읽은 데이터 : Data-3
		*/
	}
}
