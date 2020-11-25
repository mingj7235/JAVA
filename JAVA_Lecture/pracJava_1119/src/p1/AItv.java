package p1;

public class AItv extends TV{
	String AI;
	@Override
	void channelUp() {
		System.out.println("AI TV 채널 업");
		channel += 10;
	}
	
	@Override
	void channelDown() {
		System.out.println("AI TV 채널 다운");
		channel -= 10;
	}
	
}
