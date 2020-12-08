package sec06.exam02_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx {
	public static void main(String[] args) {
		Queue<Message> messageQueue = new LinkedList <Message> ();
		//LinkedList가 Queue를 구현하고있음
		
		messageQueue.offer(new Message("send Mail", "홍길동"));
		messageQueue.offer(new Message("send SMS", "신용권"));
		messageQueue.offer(new Message("send Kakaotalk", "홍두께"));
		
		while (!messageQueue.isEmpty() ) {
			Message message = messageQueue.poll(); //메세지 가져오고 큐에서 삭제
			switch (message.command) {
			case "send Mail" : 
				System.out.println(message.to + "님에게 메일을 보냅니다.");
				break;
			case "send SMS" :
				System.out.println(message.to + "님에게 SMS를 보냅니다.");
				break;
			case "send Kakaotalk" :
				System.out.println(message.to + "님에게 카톡을 보냅니다.");
				break;
			}
		}
	}
}
