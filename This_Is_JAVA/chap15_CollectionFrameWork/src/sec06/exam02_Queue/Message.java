package sec06.exam02_Queue;

public class Message {
	public String command; //메세지 종류
	public String to; //누구에게 보낼것이냐
	
	public Message(String command, String to) {
		this.command = command;
		this.to = to;
	}
	
	
}
